package com.cmash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

public class LLVMAction extends CmashBaseListener {

    private boolean inFunction = false;
    
    // Map variable names -> info. 
    // For local variables, pointerName will be something like "%x.addr"
    private Map<String, VariableInfo> localVars = new HashMap<>();
    
    // For global variables, pointerName might be "@gVarName"
    private Map<String, VariableInfo> globalVars = new HashMap<>();
    
    // ------------------------------
    // 2) Storing Partial Expression Results
    // ------------------------------
    // For each parse-tree node, store a ValueAndType with (register, llvmType)
    private Map<ParserRuleContext, ValueAndType> values = new HashMap<>();

    private Map<CmashParser.SelectionStatementContext, SelectionLabels> selectionLabels = new HashMap<>();

    // Map to store the aggregated list of print arguments for each printArgs context.
    private Map<CmashParser.PrintArgsContext, PrintArgList> printArgLists = new HashMap<>();


    private String mapType(String type) {
        // Remove any whitespace for safety.
        type = type.trim();
        switch (type) {
            case "int":
                return "i32";
            case "float":
                return "float";
            case "double":
                return "double";
            case "bool":
                return "i1";
            case "void":
                return "void";
            case "char":
                return "i8";
            // If you support other types (e.g., struct types), handle them here.
            default:
                // For unrecognized types, you could either throw an error or return a default.
                System.err.println("Warning: Unrecognized type '" + type + "'. Defaulting to i32.");
                return "i32";
        }
    }
    
    private int parseCharLiteral(String text) {
        // e.g. "'a'" or "'\\n'"
        if (text.length() >= 3) {
            char c = text.charAt(1);
            // simplistic approach for escapes
            return (int)c;
        }
        return 0;
    }

    @Override
    public void exitProgram(CmashParser.ProgramContext ctx) {
        System.out.println(LLVMGenerator.generate());
    }

    @Override
    public void enterProgram(CmashParser.ProgramContext ctx) {
        LLVMGenerator.reset();
    
        // Clear global and local variable symbol tables.
        globalVars.clear();
        localVars.clear();
    }

    @Override
    public void exitDeclaration(CmashParser.DeclarationContext ctx) {
        // Check if this declaration is for normal variable declarations.
        if (ctx.type() != null && ctx.variableList() != null) {
            // Retrieve the LLVM type computed for the type node.
            ValueAndType typeVAT = values.get(ctx.type());
            String llvmType = (typeVAT != null) ? typeVAT.register : "i32"; // default to i32 if missing

            // (Optional) Gather variable names for debugging or propagation.
            List<String> varNames = new ArrayList<>();
            for (CmashParser.VariableContext varCtx : ctx.variableList().variable()) {
                varNames.add(varCtx.ID().getText());
            }
            String debugInfo = "Declaration: " + llvmType + " " + String.join(", ", varNames);
        
            // Store the combined result for the declaration.
            // This doesn't emit any new IR instructions, because those were already
            // emitted in exitVariable.
            values.put(ctx, new ValueAndType(debugInfo, "declaration"));
        }
        // If your declaration rule has alternatives (like stringDeclaration), handle them here.
        else if (ctx.stringDeclaration() != null) {
            ValueAndType stringDecl = values.get(ctx.stringDeclaration());
            values.put(ctx, stringDecl);
        }
    }

    @Override
    public void exitValues(CmashParser.ValuesContext ctx) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void exitValue(CmashParser.ValueContext ctx) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void exitArraySize(CmashParser.ArraySizeContext ctx) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void exitMatrixSize(CmashParser.MatrixSizeContext ctx) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void exitMatrixRow(CmashParser.MatrixRowContext ctx) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void exitStringDeclaration(CmashParser.StringDeclarationContext ctx) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void exitVariableList(CmashParser.VariableListContext ctx) {
        // Create a list to collect the names of the variables declared in this list.
        List<String> varNames = new ArrayList<>();
    
        // Iterate over each 'variable' child. We assume that each variable's IR
        // has been generated in exitVariable.
        for (CmashParser.VariableContext varCtx : ctx.variable()) {
            varNames.add(varCtx.ID().getText());
        }
    
        // Optionally, join the variable names into a string for debugging or propagation.
        String combinedNames = String.join(", ", varNames);
    
        // Store this aggregated result in the values map. The type "varList" is just a marker.
        values.put(ctx, new ValueAndType(combinedNames, "varList"));
    }

    @Override
    public void exitVariable(CmashParser.VariableContext ctx) {
        String varName = ctx.ID().getText();

        // Determine the LLVM type from the parent declaration's type.
        // Default to "i32" if not found.
        String llvmType = "i32";
        CmashParser.VariableListContext parent = (CmashParser.VariableListContext) ctx.getParent();
        if (parent.getParent() instanceof CmashParser.DeclarationContext) {
            CmashParser.DeclarationContext declCtx = (CmashParser.DeclarationContext) parent.getParent();
            if (declCtx.type() != null) {
                ValueAndType typeVAT = values.get(declCtx.type());
                if (typeVAT != null) {
                    llvmType = typeVAT.register;
                }
            }
        }

        // If we're inside a function, handle local variables.
        if (inFunction) {
            // When allocating memory for a new variable
            String localPtr = "%" + varName + ".addr";
            // If the variable is a float, add ", align 4" to the alloca instruction.
            if (llvmType.equals("float")) {
                LLVMGenerator.emit(localPtr + " = alloca " + llvmType + ", align 4");

            } else if (llvmType.equals("double")) {
                // Optionally, use align 8 for doubles (depending on your platform and desired alignment).
                LLVMGenerator.emit(localPtr + " = alloca " + llvmType + ", align 8");
            } else {
                LLVMGenerator.emit(localPtr + " = alloca " + llvmType);
            }

            localVars.put(varName, new VariableInfo(localPtr, llvmType));
            if (ctx.expression() != null) {
                // Special procedure for float
                ValueAndType initVal = values.get(ctx.expression());

                if(llvmType.equals("float"))
                {
                    LLVMGenerator.FloatValueStore(localPtr, initVal);
                }
                else
                {
                    LLVMGenerator.emit("store " + llvmType + " " + initVal.register + ", " + llvmType + "* " + localPtr);
                }
            }
        } else {
            // Global variable handling.
            String globalName = "@" + varName;
            String initValStr = "0";
            if (ctx.expression() != null) {
                ValueAndType initVal = values.get(ctx.expression());
                initValStr = initVal.register;
            }
            LLVMGenerator.declareGlobal(varName, llvmType, initValStr);
            globalVars.put(varName, new VariableInfo(globalName, llvmType));
            values.put(ctx, new ValueAndType("", llvmType));
        }
    }

    @Override
    public void enterFunctionDefinition(CmashParser.FunctionDefinitionContext ctx) {
        // Indicate that we are inside a function.
        inFunction = true;
        // Clear local variables from any previous function.
        localVars.clear();

        // Retrieve the return type and map it to the corresponding LLVM type.
        String returnType = mapType(ctx.type().getText());
        // Retrieve the function name.
        String funcName = ctx.ID().getText();

        // Build the parameter signature.
        String paramSignature = "";
        if (ctx.parameters() != null && ctx.parameters().parameter() != null) {
            List<String> paramParts = new ArrayList<>();
            for (CmashParser.ParameterContext pCtx : ctx.parameters().parameter()) {
                String paramLLVMType = mapType(pCtx.type().getText());
                String paramName     = pCtx.ID().getText();
                // Each parameter is declared as "llvmType %paramName"
                paramParts.add(paramLLVMType + " %" + paramName);
            }
            paramSignature = String.join(", ", paramParts);
        }

        // Emit the function header using the LLVMGenerator.
        LLVMGenerator.startFunction(funcName, returnType, paramSignature);

        // For each parameter, allocate local storage and store the incoming parameter.
        if (ctx.parameters() != null && ctx.parameters().parameter() != null) {
            for (CmashParser.ParameterContext pCtx : ctx.parameters().parameter()) {
                String paramLLVMType = mapType(pCtx.type().getText());
                String paramName     = pCtx.ID().getText();
                // Create a local pointer name, for example: %Test.addr
                String localPtr = "%" + paramName + ".addr";
                // Allocate space on the stack.

                LLVMGenerator.emit(localPtr + " = alloca " + paramLLVMType);
                // Store the incoming parameter (which is available as "%" + paramName)
                // into the allocated stack slot.
                LLVMGenerator.emit("store " + paramLLVMType + " %" + paramName + ", " + paramLLVMType + "* " + localPtr);
                // Record the local variable in the symbol table.
                localVars.put(paramName, new VariableInfo(localPtr, paramLLVMType));
            }
        }
    }

    @Override
    public void exitFunctionDefinition(CmashParser.FunctionDefinitionContext ctx) {
        // End the function definition (emit the closing brace and a blank line).
        LLVMGenerator.endFunction();
    
        // Exit the function scope: reset the flag and clear the local symbol table.
        inFunction = false;
        localVars.clear();
    }

    @Override
    public void exitStructDefinition(CmashParser.StructDefinitionContext ctx) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void exitCompoundStruct(CmashParser.CompoundStructContext ctx) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void exitStructMember(CmashParser.StructMemberContext ctx) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void exitType(CmashParser.TypeContext ctx) {
        String llvmType;
    
    // For simple (built-in) types, the type rule will have only one child.
    if (ctx.getChildCount() == 1) {
        String typeText = ctx.getText().trim();
        llvmType = mapType(typeText);
    } else {
        // For compound types, examine the first token.
        String firstToken = ctx.getChild(0).getText();
        if (firstToken.equals("struct")) {
            // For struct types, use a naming scheme like %struct.<Name>
            String structName = ctx.ID().getText();
            llvmType = "%struct." + structName;
        } else if (firstToken.equals("string")) {
            // Map string types to i8* (pointer to 8-bit integers)
            llvmType = "i8*";
        } else {
            // Fallback: default to i32.
            llvmType = "i32";
        }
    }
    
    // Store the computed LLVM type in the shared values map.
    // Here we store it in both fields of ValueAndType.
    values.put(ctx, new ValueAndType(llvmType, llvmType));
    }

    @Override
    public void exitParameters(CmashParser.ParametersContext ctx) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void exitParameter(CmashParser.ParameterContext ctx) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void exitCompoundStatement(CmashParser.CompoundStatementContext ctx) {
        int childCount = ctx.getChildCount();
        if (childCount >= 3) { // there is at least one inner node besides the braces
            // The last meaningful child is usually at index childCount - 2 (the last token is '}')
            ParseTree lastChild = ctx.getChild(childCount - 2);
            if (lastChild instanceof ParserRuleContext) {
                ValueAndType lastValue = values.get((ParserRuleContext) lastChild);
                if (lastValue != null) {
                    values.put(ctx, lastValue);
                }
            }
        } else {
            // If the compound statement is empty, we can choose to store a "void" result.
            values.put(ctx, new ValueAndType("", "void"));
        }
    }

    @Override
    public void exitStatement(CmashParser.StatementContext ctx) {
        ValueAndType result = null;
    
        // Iterate over the children of the statement node.
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof ParserRuleContext) {
                ValueAndType childResult = values.get((ParserRuleContext) child);
                if (childResult != null) {
                    result = childResult;
                    break; // take the first computed result
                }
            }
        }
    
        // If no child produced a value, we may decide to use a default.
        if (result == null) {
            // For example, you might choose a default "void" value.
            result = new ValueAndType("", "void");
        }
    
        // Store the computed value (or default) for the statement node.
        values.put(ctx, result);
    }

    @Override
    public void exitExpressionStatement(CmashParser.ExpressionStatementContext ctx) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void exitExpression(CmashParser.ExpressionContext ctx) {
        // Try to retrieve a computed value from one of the children.
        ValueAndType result = null;
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof ParserRuleContext) {
                result = values.get((ParserRuleContext) child);
                if (result != null) {
                    break;
                }
            }
        }
    
        // Fallback: if no value was found, check if the entire expression text is a numeric literal.
        if (result == null) {
            System.err.println("\t" + ctx.getText());
            String text = ctx.getText().trim();
            // A regex that matches integer, float, and double literals:
            // - Optional sign, digits with optional decimal point, optional exponent, and optional trailing f/F.
            if (text.matches("[-+]?\\d*\\.?\\d+([eE][-+]?\\d+)?[fF]?")) {
                // Determine if the literal should be treated as float/double or as an integer.
                if (text.contains(".") || text.toLowerCase().contains("e") || text.toLowerCase().endsWith("f")) {
                    if (text.toLowerCase().endsWith("f")) {
                        // It's a float literal. Remove trailing 'f' and format.
                        text = text.substring(0, text.length() - 1);
                        try {
                            if (text.endsWith("f") || text.endsWith("F")) {
                                text = text.substring(0, text.length() - 1);
                            }
                            float value = Float.parseFloat(text);
                            // Get the raw 32-bit representation of the float.
                            int bits = Float.floatToIntBits(value);
                            // Format it as an 8-digit hexadecimal constant.
                            String formatted = "0x" + String.format("%08X", bits);
                            result = new ValueAndType(formatted, "float");
                        } catch (NumberFormatException e) {
                            result = new ValueAndType("0.0", "float");
                        }
                    } else {
                        // Treat as double.
                        try {
                            result = new ValueAndType(text, "double");
                        } catch (NumberFormatException e) {
                            result = new ValueAndType("0.0", "double");
                        }
                    }
                } else {
                    // It's an integer literal.
                    result = new ValueAndType(text, "i32");
                }
            } else if (inFunction && localVars.containsKey(text)) {
                // If the text is a variable name, retrieve its LLVM representation.
                VariableInfo varInfo = localVars.get(text);
                result = new ValueAndType(LLVMGenerator.loadValue(varInfo.llvmType, varInfo.pointerName), varInfo.llvmType);
            } else if (globalVars.containsKey(text)) {
                // If the text is a global variable name, retrieve its LLVM representation.
                VariableInfo varInfo = globalVars.get(text);
                result = new ValueAndType(LLVMGenerator.loadValue(varInfo.llvmType, varInfo.pointerName), varInfo.llvmType);
            } else {
                result = new ValueAndType("0", "i32");
            }
        }
        
        System.out.println(";" + result.llvmType + " " + result.register);
        values.put(ctx, result);
    }

    @Override
    public void exitAssignment(CmashParser.AssignmentContext ctx) {
        // Case 1: Assignment to a variable using an ID.
        if (ctx.ID() != null) {
            String varName = ctx.ID().getText();
            // Evaluate the right-hand side expression.
            ValueAndType rhs = values.get(ctx.expression());
        
            // Look up the variable pointer in localVars (if inside a function) or globalVars.
            VariableInfo varInfo = inFunction ? localVars.get(varName) : globalVars.get(varName);
            if (varInfo == null) {
                System.err.println("Error: variable " + varName + " is not declared.");
                return;
            }
        
            // Emit a store instruction to update the variable's value.
            LLVMGenerator.emit("store " + varInfo.llvmType + " " + rhs.register + ", " +
                               varInfo.llvmType + "* " + varInfo.pointerName);
            
            // Propagate the right-hand side value as the result of the assignment.
            values.put(ctx, rhs);
        }
        // Case 2: Assignment to a field (for example, via a fieldAccess rule).
        else if (ctx.fieldAccess() != null) {
            // Assume exitFieldAccess stored a pointer to the field in the values map.
            ValueAndType fieldPtr = values.get(ctx.fieldAccess());
            ValueAndType rhs = values.get(ctx.expression());
        
            // Emit a store instruction to update the field.
            LLVMGenerator.emit("store " + rhs.llvmType + " " + rhs.register + ", " +
                               rhs.llvmType + "* " + fieldPtr.register);
            values.put(ctx, rhs);
        }
        // Case 3: Fallback (if the rule falls back to an equality expression).
        else {
            // In this case, simply propagate the result from the equality alternative.
            values.put(ctx, values.get(ctx.equality()));
        }
    }

    @Override
    public void exitEquality(CmashParser.EqualityContext ctx) {
        // If there is only one relational expression, simply propagate its value.
        if (ctx.relational().size() == 1) {
            values.put(ctx, values.get(ctx.relational(0)));
            return;
        }
    
        // Start with the result of the first relational subexpression.
        ValueAndType leftVAT = values.get(ctx.relational(0));
    
        // Process each equality operator and its corresponding relational subexpression.
        for (int i = 1; i < ctx.relational().size(); i++) {
            // Retrieve the operator; it should be at positions 1, 3, 5, ... in the parse tree.
            String op = ctx.getChild(2 * i - 1).getText(); // "==" or "!="
            ValueAndType rightVAT = values.get(ctx.relational(i));
        
            // Assume both operands share the same type.
            String resultType = leftVAT.llvmType;
            String newReg = LLVMGenerator.newTempReg();
        
            if (resultType.equals("i32") || resultType.equals("i1") || resultType.equals("i8")) {
                // For integral types, use icmp with predicates eq (for "==") or ne (for "!=").
                String predicate = op.equals("==") ? "eq" : "ne";
                LLVMGenerator.emit(newReg + " = icmp " + predicate + " " + resultType + " " 
                                   + leftVAT.register + ", " + rightVAT.register);
                leftVAT = new ValueAndType(newReg, "i1");
            } else if (resultType.equals("float") || resultType.equals("double")) {
                // For floating-point types, use fcmp with predicates oeq (for "==") or one (for "!=").
                String predicate = op.equals("==") ? "oeq" : "one";
                LLVMGenerator.emit(newReg + " = fcmp " + predicate + " " + resultType + " " 
                                   + leftVAT.register + ", " + rightVAT.register);
                leftVAT = new ValueAndType(newReg, "i1");
            } else {
                // Fallback: if the type is unrecognized, default to false.
                leftVAT = new ValueAndType("0", "i1");
            }
        }
    
        // Store the final computed equality result in the values map.
        values.put(ctx, leftVAT);
    }

    @Override
    public void exitRelational(CmashParser.RelationalContext ctx) {
        // If there's only one additive, there's no relational operator.
        if (ctx.additive().size() == 1) {
            values.put(ctx, values.get(ctx.additive(0)));
            return;
        }

        // Start with the result of the first additive subexpression.
        ValueAndType leftVAT = values.get(ctx.additive(0));

        // Process each relational operator and its corresponding additive subexpression.
        for (int i = 1; i < ctx.additive().size(); i++) {
            // Operators appear between the additive nodes; e.g., at child positions 1, 3, 5, ...
            String op = ctx.getChild(2 * i - 1).getText();
            ValueAndType rightVAT = values.get(ctx.additive(i));
        
            // Assume that both operands have the same type.
            String resultType = leftVAT.llvmType;
            String newReg = LLVMGenerator.newTempReg();
        
            // If the operands are integers (or integral types), use icmp instructions.
            if (resultType.equals("i32") || resultType.equals("i1") || resultType.equals("i8")) {
                String predicate = "";
                if (op.equals("<")) {
                    predicate = "slt";
                } else if (op.equals(">")) {
                    predicate = "sgt";
                } else if (op.equals("<=")) {
                    predicate = "sle";
                } else if (op.equals(">=")) {
                    predicate = "sge";
                }
                LLVMGenerator.emit(newReg + " = icmp " + predicate + " " + resultType + " " +
                                   leftVAT.register + ", " + rightVAT.register);
                // The result of an icmp is always an i1.
                leftVAT = new ValueAndType(newReg, "i1");
            }
            // If the operands are floating-point numbers, use fcmp instructions.
            else if (resultType.equals("float") || resultType.equals("double")) {
                String predicate = "";
                if (op.equals("<")) {
                    predicate = "olt";
                } else if (op.equals(">")) {
                    predicate = "ogt";
                } else if (op.equals("<=")) {
                    predicate = "ole";
                } else if (op.equals(">=")) {
                    predicate = "oge";
                }
                LLVMGenerator.emit(newReg + " = fcmp " + predicate + " " + resultType + " " +
                                   leftVAT.register + ", " + rightVAT.register);
                leftVAT = new ValueAndType(newReg, "i1");
            }
            else {
                // Fallback: if the type isn't recognized, default to false.
                leftVAT = new ValueAndType("0", "i1");
            }
        }
    
        // Store the final computed relational result in the shared values map.
        values.put(ctx, leftVAT);
    }

    @Override
    public void exitAdditive(CmashParser.AdditiveContext ctx) {
        // Get the result of the first multiplicative subexpression.
        ValueAndType leftVAT = values.get(ctx.multiplicative(0));

        // Process each ('+' | '-') operation.
        for (int i = 1; i < ctx.multiplicative().size(); i++) {
            // Operators appear at positions 1, 3, 5, etc.
            String op = ctx.getChild(2 * i - 1).getText();
            ValueAndType rightVAT = values.get(ctx.multiplicative(i));
        
            // Assume that both operands are of the same type.
            String resultType = leftVAT.llvmType;
            String newReg = LLVMGenerator.newTempReg();
        
            // Determine if we use integer or floating-point instructions.
            boolean isInteger = resultType.equals("i32") || resultType.equals("i1") || resultType.equals("i8");
            boolean isFloat   = resultType.equals("float");
            boolean isDouble  = resultType.equals("double");

            // Emit the proper instruction based on the operator and operand types.
            if (op.equals("+")) {
                if (isInteger) {
                    LLVMGenerator.emit(newReg + " = add " + resultType + " " 
                                       + leftVAT.register + ", " + rightVAT.register);
                } else {
                    LLVMGenerator.emit(newReg + " = fadd " + resultType + " " 
                                       + leftVAT.register + ", " + rightVAT.register);
                }
            } else if (op.equals("-")) {
                if (isInteger) {
                    LLVMGenerator.emit(newReg + " = sub " + resultType + " " 
                                       + leftVAT.register + ", " + rightVAT.register);
                } else {
                    LLVMGenerator.emit(newReg + " = fsub " + resultType + " " 
                                       + leftVAT.register + ", " + rightVAT.register);
                }
            }
        
            // The result becomes the new left-hand value for subsequent operations.
            leftVAT = new ValueAndType(newReg, resultType);
        }
    
        // Store the final result in the values map for the additive context.
        values.put(ctx, leftVAT);
    }

    @Override
    public void exitMultiplicative(CmashParser.MultiplicativeContext ctx) {
        // Get the result of the first primary subexpression.
        ValueAndType leftVAT = values.get(ctx.primary(0));

        // Process each operator and the corresponding primary.
        for (int i = 1; i < ctx.primary().size(); i++) {
            // The operator is found at position 2*i - 1 in the children list.
            String op = ctx.getChild(2 * i - 1).getText();
            ValueAndType rightVAT = values.get(ctx.primary(i));
        
            String resultType = leftVAT.llvmType;  // Assume both operands share the same type.
            String newReg = LLVMGenerator.newTempReg();
        
            // Determine if we're dealing with integer or floating-point operations.
            boolean isInteger = resultType.equals("i32") || resultType.equals("i1") || resultType.equals("i8");
            boolean isFloat   = resultType.equals("float");
            boolean isDouble  = resultType.equals("double");
        
            if (op.equals("*")) {
                if (isInteger) {
                    LLVMGenerator.emit(newReg + " = mul " + resultType + " " + leftVAT.register + ", " + rightVAT.register);
                } else { // For float or double, use fmul.
                    LLVMGenerator.emit(newReg + " = fmul " + resultType + " " + leftVAT.register + ", " + rightVAT.register);
                }
            } else if (op.equals("/")) {
                if (isInteger) {
                    // For integers, use signed division (sdiv).
                    LLVMGenerator.emit(newReg + " = sdiv " + resultType + " " + leftVAT.register + ", " + rightVAT.register);
                } else {
                    LLVMGenerator.emit(newReg + " = fdiv " + resultType + " " + leftVAT.register + ", " + rightVAT.register);
                }
            } else if (op.equals("%")) {
                if (isInteger) {
                    LLVMGenerator.emit(newReg + " = srem " + resultType + " " + leftVAT.register + ", " + rightVAT.register);
                } else {
                    // For floating-point, LLVM may support frem in newer versions.
                    // Otherwise, you might need to call a library function or issue a warning.
                    LLVMGenerator.emit("; WARNING: float/double '%' not implemented; using placeholder");
                    LLVMGenerator.emit(newReg + " = fdiv " + resultType + " 0.0, 0.0");
                }
            }
        
            // Update the left-hand side for the next iteration.
            leftVAT = new ValueAndType(newReg, resultType);
        }
    
        // Store the final computed result for the multiplicative expression.
        values.put(ctx, leftVAT);
    }

    @Override
    public void exitFieldAccess(CmashParser.FieldAccessContext ctx) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void exitFunctionCall(CmashParser.FunctionCallContext ctx) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void exitPrimary(CmashParser.PrimaryContext ctx) {
        if (ctx.INT() != null) {
            values.put(ctx, new ValueAndType(ctx.INT().getText(), "i32"));
        } else if (ctx.FLOAT() != null) {
            String floatText = ctx.FLOAT().getText();
            // Remove trailing 'f' or 'F' if present.
            if (floatText.endsWith("f") || floatText.endsWith("F")) {
                floatText = floatText.substring(0, floatText.length() - 1);
            }
            float value = Float.parseFloat(floatText);
            // Get the raw 32-bit representation of the float.
            int bits = Float.floatToIntBits(value);
            // Format it as an 8-digit hexadecimal constant.
            String formatted = "0x" + String.format("%08X", bits);
            values.put(ctx, new ValueAndType(formatted, "float"));
        } else if (ctx.DOUBLE() != null) {
            String doubleText = ctx.DOUBLE().getText();
            values.put(ctx, new ValueAndType(doubleText, "double"));
        } else if (ctx.BOOL_LITERAL() != null) {
            String boolVal = ctx.BOOL_LITERAL().getText().equals("true") ? "1" : "0";
            values.put(ctx, new ValueAndType(boolVal, "i1"));
        } else if (ctx.CHAR_LITERAL() != null) {
            int ascii = parseCharLiteral(ctx.CHAR_LITERAL().getText());
            values.put(ctx, new ValueAndType(String.valueOf(ascii), "i32"));
        } else if (ctx.ID() != null) {
            String varName = ctx.ID().getText();
            VariableInfo varInfo = inFunction ? localVars.get(varName) : globalVars.get(varName);
            if (varInfo != null) {
                String tmpReg = LLVMGenerator.newTempReg();
                LLVMGenerator.emit(tmpReg + " = load " + varInfo.llvmType + ", " +
                                   varInfo.llvmType + "* " + varInfo.pointerName);
                values.put(ctx, new ValueAndType(tmpReg, varInfo.llvmType));
            } else {
                values.put(ctx, new ValueAndType("0", "i32"));
            }
        } else if (ctx.expression() != null) {
            values.put(ctx, values.get(ctx.expression()));
        }
    }

    @Override
    public void exitNumbers(CmashParser.NumbersContext ctx) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void exitArrayAccess(CmashParser.ArrayAccessContext ctx) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void enterSelectionStatement(CmashParser.SelectionStatementContext ctx) {
        // Create labels using the helper. If an ELSE exists, pass true.
        SelectionLabels labels = LLVMGenerator.newSelectionLabels(ctx.ELSE() != null);
        // Store them in a local map for retrieval later.
        selectionLabels.put(ctx, labels);
    
        // Optionally, you can emit a comment for debugging.
        LLVMGenerator.emit("; Entering selection statement with labels: then=" + labels.thenLabel +
                           " else=" + labels.elseLabel + " merge=" + labels.mergeLabel);
    }

    @Override
public void exitSelectionStatement(CmashParser.SelectionStatementContext ctx) {
        // Retrieve the condition's computed value (should be i1).
        ValueAndType condVAT = values.get(ctx.expression());
        String condReg = condVAT.register;
    
        // Retrieve the labels from our map.
        SelectionLabels labels = selectionLabels.get(ctx);
    
        // Use LLVMGenerator's helper to emit the conditional branch.
        LLVMGenerator.emitConditionalBranch(condReg, labels);
    
        // Emit the then branch label.
        LLVMGenerator.emit(labels.thenLabel + ":");
        // (The IR for the then-statement is assumed to be generated in its exit method.)
        // After then, jump unconditionally to merge.
        LLVMGenerator.emit("br label %" + labels.mergeLabel);
    
        // If there is an else branch, emit its label and branch to merge.
        if (labels.elseLabel != null) {
            LLVMGenerator.emit(labels.elseLabel + ":");
            // (The IR for the else-statement is assumed to be generated.)
            LLVMGenerator.emit("br label %" + labels.mergeLabel);
        }
    
        // Finally, emit the merge label.
        LLVMGenerator.emit(labels.mergeLabel + ":");
    
        // Since a selection statement typically doesn't produce a value, we record void.
        values.put(ctx, new ValueAndType("", "void"));
    }

    @Override
    public void exitIterationStatement(CmashParser.IterationStatementContext ctx) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void exitLoopStatement(CmashParser.LoopStatementContext ctx) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void enterIoStatement(CmashParser.IoStatementContext ctx) {
        LLVMGenerator.emit("; Entering IO statement");
    }

    @Override
    public void exitIoStatement(CmashParser.IoStatementContext ctx) {
        String token = ctx.getChild(0).getText();
        if (token.equals("print")) {
            PrintArgList pal = printArgLists.get(ctx.printArgs());
            if (pal != null && !pal.args.isEmpty()) {
                // For demonstration, assume we print the first argument.
                ValueAndType arg = pal.args.get(0);
                String formatStr;
                if (arg.llvmType.equals("i32")) {
                    formatStr = "@strpi";  // use integer format
                } else if (arg.llvmType.equals("float")) {
                    formatStr = "@strf";  // use float format
                } else if (arg.llvmType.equals("double")) {
                    formatStr = "@strlf"; // use double format
                } else if (arg.llvmType.equals("i8*")) {
                    formatStr = "@strs";  // use string format
                } else {
                    formatStr = "@strd";  // default to integer
                }
                // Here, adjust the GEP instruction according to the actual array size in the format string global.
                // For example, if @strlf is defined as [5 x i8], use 5, and if @strf is [4 x i8], use 4.
                String gepSize;
                String callInstr;

                //Special cases first:
                if(arg.llvmType.equals("float"))
                {
                    // Need to be extended to double first
                    String tempreg = LLVMGenerator.FloatToDouble(arg.register);
                    callInstr = "call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([5 x i8], [5 x i8]* @strlf, i32 0, i32 0), double " + tempreg + ")\n";
                }
                else
                {
                    if (arg.llvmType.equals("double"))
                        gepSize = "5";
                    else if (arg.llvmType.equals("i32"))
                        gepSize = "4";
                    else if (arg.llvmType.equals("i8*"))
                        gepSize = "4";
                    else
                        gepSize = "4";
                
                    callInstr = "call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([" + gepSize + " x i8], [" + gepSize + " x i8]* " 
                                        + formatStr + ", i32 0, i32 0), " 
                                        + arg.llvmType + " " + arg.register + ")";
                }
                
                LLVMGenerator.emit(callInstr);
            } else {
                LLVMGenerator.emit("; Warning: no print arguments provided");
            }
        } else if (token.equals("read")) {
            // Handle read similarly.
        }
    }

    @Override
    public void exitJumpStatement(CmashParser.JumpStatementContext ctx) {
        // Check if there is a return expression.
        if (ctx.expression() != null) {
            // Retrieve the computed value from the expression.
            ValueAndType retVal = values.get(ctx.expression());
            if (retVal != null) {
                // Emit the return instruction with the appropriate LLVM type and register.
                LLVMGenerator.emit("ret " + retVal.llvmType + " " + retVal.register);
                // Propagate the value as the result of the jump statement.
                values.put(ctx, retVal);
            } else {
                // Fallback: if for some reason the expression did not compute a value, return 0.
                LLVMGenerator.emit("ret i32 0");
                values.put(ctx, new ValueAndType("0", "i32"));
            }
        } else {
            // If there is no expression, emit a void return.
            LLVMGenerator.emit("ret void");
            values.put(ctx, new ValueAndType("", "void"));
        }
    }

    @Override
    public void enterPrintArgs(CmashParser.PrintArgsContext ctx) {
        // Optionally, initialize an empty list for this context.
        // (We will actually build the list in exitPrintArgs.)
        // You might also add a debug comment if desired:
        LLVMGenerator.emit("; Entering printArgs");
    }

    @Override
    public void exitPrintArgs(CmashParser.PrintArgsContext ctx) {
        List<ValueAndType> argList = new ArrayList<>();
    
        // Iterate over each printArg child.
        for (CmashParser.PrintArgContext argCtx : ctx.printArg()) {
            // Retrieve the computed value for this printArg (set in exitPrintArg).
            ValueAndType vat = values.get(argCtx);
            if (vat != null) {
                argList.add(vat);
            }
        }
    
        // Create a helper object to hold the list.
        PrintArgList pal = new PrintArgList(argList);
        // Save it in our dedicated map.
        printArgLists.put(ctx, pal);
    
        // Optionally, store a marker in the shared values map for this context.
        // For example, we set both fields to a marker string.
        values.put(ctx, new ValueAndType("printArgList", "printArgList"));
    
        // Emit a debug comment.
        LLVMGenerator.emit("; Exiting printArgs with " + argList.size() + " arguments");
    }

    @Override
    public void exitPrintArg(CmashParser.PrintArgContext ctx) {
        if (ctx.expression() != null) {
            ValueAndType vat = values.get(ctx.expression());
            if (vat == null) {
                System.err.println("exitPrintArg: ERROR, expression value is null");
            }
            values.put(ctx, vat);
        } else if (ctx.PLAIN_TEXT() != null) {
            String text = ctx.PLAIN_TEXT().getText();
            text = text.substring(1, text.length() - 1);
            String ptr = LLVMGenerator.newGlobalString(text);
            values.put(ctx, new ValueAndType(ptr, "i8*"));
        }
    }

}
