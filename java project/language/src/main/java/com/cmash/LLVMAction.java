package com.cmash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

public class LLVMAction extends CmashBaseListener {

    private boolean inFunction = false;
    private static int matrixConstCounter = 0;  // Add this at the class level
    
    // Local variables kept in different scopes
    private enum ScopeType { GLOBAL, FUNCTION, LOOP, CLASS, BLOCK, STRUCT }
    private Stack<Scope> scopes = new Stack<>();
    
    // For global variables, pointerName might be "@gVarName"
    private Map<String, VariableInfo> globalVars = new HashMap<>();

    // Map function name → its LLVM return type
    private final Map<String,String> functionReturnTypes = new HashMap<>();

    // Map to store the parameter values for function calls
    private final Map<CmashParser.ParametersContext, List<ValueAndType>> paramValues = new HashMap<>();
    
    // ------------------------------
    // 2) Storing Partial Expression Results
    // ------------------------------
    // For each parse-tree node, store a ValueAndType with (register, llvmType)
    private Map<ParserRuleContext, ValueAndType> values = new HashMap<>();

    private Map<CmashParser.SelectionStatementContext, SelectionLabels> selectionLabels = new HashMap<>();

    // Map to store the aggregated list of print arguments for each printArgs context.
    private Map<CmashParser.PrintArgsContext, PrintArgList> printArgLists = new HashMap<>();

    private final Map<ParserRuleContext,LoopLabels> loopLabels = new HashMap<>();
    private Map<String, StructInfo> structs = new HashMap<>();
    private String currentStructName = null;


    private String mapType(String type) {
        // Remove any whitespace for safety.
        type = type.trim();
        if (type.startsWith("struct ")) {
            return "%struct." + type.substring(7);
        }

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

    private static class Scope {
        ScopeType type;
        Map<String, VariableInfo> variables;

        Scope(ScopeType type) {
            this.type = type;
            this.variables = new HashMap<>();
        }
    }

    private static class StructInfo {
        List<Member> members = new ArrayList<>();

        static class Member {
            String name;
            String llvmType;
            Member(String name, String llvmType) {
                this.name = name;
                this.llvmType = llvmType;
            }
        }

        public void addMember(String name, String llvmType) {
            members.add(new Member(name, llvmType));
        }

        public int getFieldIndex(String name) {
            for (int i = 0; i < members.size(); i++) {
                if (members.get(i).name.equals(name)) return i;
            }
            return -1;
        }

        public String getMemberType(String name) {
            for (Member m : members) {
                if (m.name.equals(name)) return m.llvmType;
            }
            return null;
        }

        public List<String> getMemberTypes() {
            return members.stream().map(m -> m.llvmType).collect(Collectors.toList());
        }
    }

    private VariableInfo getVariableInfo(String varName) {
        for (int i = scopes.size() - 1; i >= 0; i--) {
            Scope scope = scopes.get(i);
            if (scope.variables.containsKey(varName)) {
                return scope.variables.get(varName);
            }
            // Stop searching if we hit a FUNCTION/CLASS boundary (no cross-scope access)
            if (scope.type == ScopeType.FUNCTION || scope.type == ScopeType.CLASS) {
                break;
            }
        }
        return globalVars.get(varName); // Fallback to globals
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
        scopes.clear();
        scopes.push(new Scope(ScopeType.GLOBAL));
    }

    @Override
    public void exitDeclaration(CmashParser.DeclarationContext ctx) {
        // Check if this declaration is for normal variable declarations.
        if (ctx.type() != null && ctx.variableList() != null) {
            // Retrieve the LLVM type computed for the type node.
            ValueAndType typeVAT = values.get(ctx.type());
            String llvmType = (typeVAT != null) ? typeVAT.register : "i32"; 

            List<String> varNames = new ArrayList<>();
            for (CmashParser.VariableContext varCtx : ctx.variableList().variable()) {
                varNames.add(varCtx.ID().getText());
            }
            String debugInfo = "Declaration: " + llvmType + " " + String.join(", ", varNames);
        
            values.put(ctx, new ValueAndType(debugInfo, "declaration"));
        }
        else if (ctx.stringDeclaration() != null) {
            ValueAndType stringDecl = values.get(ctx.stringDeclaration());
            values.put(ctx, stringDecl);
        }

        // if this decl is the first child inside a for(…;…;…)
        if ( ctx.getParent() instanceof CmashParser.LoopStatementContext && ((CmashParser.LoopStatementContext)ctx.getParent()).declaration() == ctx ) {
            LoopLabels L = loopLabels.get(ctx.getParent());
            // terminate entry and jump to cond
            LLVMGenerator.emit("br label %" + L.condLabel);
            // start the cond block
            LLVMGenerator.emitBlock(L.condLabel);
        }
    }

    @Override
    public void exitValues(CmashParser.ValuesContext ctx) {
        // Create a list to store the computed elements.
        List<ValueAndType> arrayElements = new ArrayList<>();
    
        for (CmashParser.ValueContext valueCtx : ctx.value()) {
            ValueAndType vat = values.get(valueCtx);
            if (vat != null) {
                arrayElements.add(vat);
            }
        }
    
        String initStr = "[" + arrayElements.stream()
                            .map(v -> v.llvmType + " " + v.register)
                            .collect(Collectors.joining(", ")) + "]";
    
        values.put(ctx, new ValueAndType(initStr, "array"));
    }


    @Override
    public void exitValue(CmashParser.ValueContext ctx) {
        // Case 1: The rule matched an identifier.
        if (ctx.ID() != null) {
            String varName = ctx.ID().getText();

            VariableInfo varInfo = inFunction ? getVariableInfo(varName) : globalVars.get(varName);
            if (varInfo != null) {
                // Load the value from the variable pointer.
                String tmpReg = LLVMGenerator.newTempReg();
                LLVMGenerator.emit(tmpReg + " = load " + varInfo.llvmType + ", " +
                                   varInfo.llvmType + "* " + varInfo.pointerName);
                values.put(ctx, new ValueAndType(tmpReg, varInfo.llvmType));
            } else {
                // If not declared, you might signal an error.
                System.err.println("Error: identifier '" + varName + "' not declared.");
                values.put(ctx, new ValueAndType("0", "i32")); // fallback
            }
        }
        // Case 2: The rule matched a numbers alternative.
        else if (ctx.numbers() != null) {
            values.put(ctx, values.get(ctx.numbers()));
        }
        // Case 3: The rule matched a character literal.
        else if (ctx.CHAR_LITERAL() != null) {
            int ascii = parseCharLiteral(ctx.CHAR_LITERAL().getText());
            // For simplicity, treat a character literal as an i32 constant.
            values.put(ctx, new ValueAndType(String.valueOf(ascii), "i32"));
        }
    }

    @Override
    public void exitArraySize(CmashParser.ArraySizeContext ctx) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void exitMatrixSize(CmashParser.MatrixSizeContext ctx) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void exitMatrixRow(CmashParser.MatrixRowContext ctx) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void exitStringDeclaration(CmashParser.StringDeclarationContext ctx) {
        String varName = ctx.ID().getText();
        String strContent = ctx.PLAIN_TEXT() != null 
            ? ctx.PLAIN_TEXT().getText().substring(1, ctx.PLAIN_TEXT().getText().length() - 1)
            : "";
    
        int arraySize = strContent.length() + 1;
    
        String escapedStr = strContent.replace("\\", "\\\\")
                                      .replace("\n", "\\0A")
                                      .replace("\t", "\\09")
                                      .replace("\"", "\\22");
    
        if (inFunction) {
            // Local variable: use memcpy to initialize stack allocation
            String globalStrName = "@." + varName + "_str";
            LLVMGenerator.emitGlobal(globalStrName + " = constant [" + arraySize + " x i8] c\"" + escapedStr + "\\00\"");
    
            String ptrReg = "%" + varName;
            LLVMGenerator.emit(ptrReg + " = alloca [" + arraySize + " x i8], align 1");
            
            // Emit memcpy to copy from global to stack
            String destCast = LLVMGenerator.newTempReg();
            String srcCast = LLVMGenerator.newTempReg();
            LLVMGenerator.emit(destCast + " = bitcast [" + arraySize + " x i8]* " + ptrReg + " to i8*");
            LLVMGenerator.emit(srcCast + " = bitcast [" + arraySize + " x i8]* " + globalStrName + " to i8*");
            LLVMGenerator.emit("call void @llvm.memcpy.p0i8.p0i8.i64(i8* " + destCast + ", i8* " + srcCast + 
                              ", i64 " + arraySize + ", i1 false)");
            
            Scope currentScope = scopes.peek();
            currentScope.variables.put(varName, new VariableInfo(ptrReg, "[" + arraySize + " x i8]*"));
        } else {
            // Global variable
            LLVMGenerator.emitGlobal("@" + varName + " = constant [" + arraySize + " x i8] c\"" + escapedStr + "\\00\"");
            globalVars.put(varName, new VariableInfo("@" + varName, "[" + arraySize + " x i8]"));
        }
    }

    @Override
    public void exitArrayDeclaration(CmashParser.ArrayDeclarationContext ctx) {
        String type = mapType(ctx.type().getText());
        String varName = ctx.ID().getText();
        List<Integer> dimensions = new ArrayList<>();
        
        // Get dimensions from arraySize rules
        for (CmashParser.ArraySizeContext sizeCtx : ctx.arraySize()) {
            dimensions.add(Integer.parseInt(sizeCtx.INT().getText()));
        }
        
        // Build LLVM array type (e.g. [2 x [3 x i32]])
        String llvmType = dimensions.stream()
            .map(size -> "[" + size + " x ")
            .collect(Collectors.joining()) + type + "]".repeat(dimensions.size());
            
        // Handle initialization
        String init = "zeroinitializer";
        List<CmashParser.ValuesContext> valuesList = ctx.values();
        if (!valuesList.isEmpty()) { // Check if there are any initializers
            if (dimensions.isEmpty()) {
                throw new RuntimeException("Array dimensions cannot be empty");
            }
            if (dimensions.size() == 1) {
                // 1D array: single ValuesContext expected
                if (valuesList.size() != 1) {
                    throw new RuntimeException("1D array initializer must have exactly one group");
                }
                CmashParser.ValuesContext vc = valuesList.get(0);
                List<ValueAndType> elements = vc.value().stream()
                    .map(valueCtx -> values.get(valueCtx))
                    .collect(Collectors.toList());
                if (elements.size() != dimensions.get(0)) {
                    throw new RuntimeException("1D array initializer has " + elements.size() + " elements, expected " + dimensions.get(0));
                }
                init = "[" + elements.stream()
                    .map(e -> e.llvmType + " " + e.register)
                    .collect(Collectors.joining(", ")) + "]";
            } else {
                // Multi-dimensional array
                int outerDim = dimensions.get(0);
                if (valuesList.size() != outerDim) {
                    throw new RuntimeException("Array initializer has " + valuesList.size() + " groups, expected " + outerDim);
                }
                List<Integer> innerDims = dimensions.subList(1, dimensions.size());
                int innerElements = innerDims.stream().reduce(1, (a, b) -> a * b);
                String innerType = buildGroupType(innerDims, type);
                List<String> subArrays = new ArrayList<>();
                for (CmashParser.ValuesContext vc : valuesList) {
                    List<ValueAndType> elements = vc.value().stream()
                        .map(valueCtx -> values.get(valueCtx))
                        .collect(Collectors.toList());
                    if (elements.size() != innerElements) {
                        throw new RuntimeException("Sub-array initializer has " + elements.size() + " elements, expected " + innerElements);
                    }
                    String elementsStr = elements.stream()
                        .map(e -> e.llvmType + " " + e.register)
                        .collect(Collectors.joining(", "));
                    subArrays.add(innerType + " [" + elementsStr + "]");
                }
                init = "[" + String.join(", ", subArrays) + "]";
            }
        }

        if (inFunction) {
            String ptrReg = "%" + varName;
            LLVMGenerator.emit(ptrReg + " = alloca " + llvmType);
            Scope currentScope = scopes.peek();
            currentScope.variables.put(varName, new VariableInfo(ptrReg, llvmType + "*"));
            if (!init.equals("zeroinitializer")) {
                String globalName = "@__const." + varName;
                LLVMGenerator.emitGlobal(globalName + " = constant " + llvmType + " " + init);
                String destCast = LLVMGenerator.newTempReg();
                String srcCast = LLVMGenerator.newTempReg();
                LLVMGenerator.emit(destCast + " = bitcast " + llvmType + "* " + ptrReg + " to i8*");
                LLVMGenerator.emit(srcCast + " = bitcast " + llvmType + "* " + globalName + " to i8*");
                long size = dimensions.stream().reduce(1, (a, b) -> a * b) * getTypeSize(type);
                LLVMGenerator.emit("call void @llvm.memcpy.p0i8.p0i8.i64(i8* " + destCast + ", i8* " + srcCast + ", i64 " + size + ", i1 false)");
            }
        } else {
            LLVMGenerator.declareGlobalArray(varName, llvmType, init);
            globalVars.put(varName, new VariableInfo("@" + varName, llvmType));
        }
    }

    private String buildGroupType(List<Integer> dims, String elementType) {
        if (dims.isEmpty()) {
            return elementType;
        }
        return dims.stream()
            .map(size -> "[" + size + " x ")
            .collect(Collectors.joining()) + elementType + "]".repeat(dims.size());
    }

    private int getTypeSize(String type) {
        switch (type) {
            case "i32": return 4;
            case "float": return 4;
            case "double": return 8;
            default: return 4;
        }
    }

	@Override public void enterMatrixDeclaration(CmashParser.MatrixDeclarationContext ctx) {
        //throw new UnsupportedOperationException("Not supported yet.");
     }

     @Override
     public void exitMatrixDeclaration(CmashParser.MatrixDeclarationContext ctx) {
        String type = mapType(ctx.numericalType().getText());
        String varName = ctx.ID().getText();
        List<Integer> dims = ctx.matrixSize().INT().stream()
            .map(t -> Integer.parseInt(t.getText()))
            .collect(Collectors.toList());
    
        // Validate matrix dimensions
        if (dims.size() < 2) {
            throw new RuntimeException("Matrix '" + varName + "' must have 2 dimensions (e.g., <rows,cols>)");
        }
        int declaredRows = dims.get(0);
        int declaredCols = dims.get(1);
    
        String llvmType = dims.stream()
            .map(d -> "[" + d + " x ")
            .collect(Collectors.joining()) + type + "]".repeat(dims.size());
    
        String init = "zeroinitializer";
        List<String> rows = new ArrayList<>();
    
        if (ctx.matrixRow() != null) {
            // Validate row count
            
            int actualRows = ctx.matrixRow().size();
            if (actualRows != declaredRows) {
                throw new RuntimeException("Matrix '" + varName + "' expects " + declaredRows + 
                    " rows, but found " + actualRows);
            }
    
            // Process each row
            for (CmashParser.MatrixRowContext rowCtx : ctx.matrixRow()) {
                List<CmashParser.NumbersContext> numbers = rowCtx.numbers();
                // Validate column count per row
                if (numbers.size() != declaredCols) {
                    throw new RuntimeException("Matrix '" + varName + "' expects " + declaredCols + 
                        " columns, but found " + numbers.size() + " in row: " + rowCtx.getText());
                }
                // Process elements
                List<String> elements = numbers.stream()
                    .map(numCtx -> {
                        ValueAndType vat = values.get(numCtx);
                        return (vat != null) ? vat.llvmType + " " + vat.register : type + " 0";
                    })
                    .collect(Collectors.toList());
                String rowType = "[" + declaredCols + " x " + type + "]";
                rows.add(rowType + " [" + String.join(", ", elements) + "]"); // 
                
            }
            init = "[" + String.join(", ", rows) + "]";
        }
     
         if (inFunction) {
            String ptrReg = "%" + varName;
            LLVMGenerator.emit(ptrReg + " = alloca " + llvmType);
            
                // Generate unique global name to avoid duplicates
                String globalName = "@__const." + varName + "." + (matrixConstCounter++);
                LLVMGenerator.emitGlobal(globalName + " = constant " + llvmType + " " + init);
                
                String destCast = LLVMGenerator.newTempReg();
                String srcCast = LLVMGenerator.newTempReg();
                LLVMGenerator.emit(destCast + " = bitcast " + llvmType + "* " + ptrReg + " to i8*");
                LLVMGenerator.emit(srcCast + " = bitcast " + llvmType + "* " + globalName + " to i8*");
                LLVMGenerator.emit("call void @llvm.memcpy.p0i8.p0i8.i64(i8* " + destCast + ", i8* " + srcCast + 
                                ", i64 " + getMatrixSize(dims, type) + ", i1 false)");
             
                Scope currentScope = scopes.peek();
                currentScope.variables.put(varName, new VariableInfo(ptrReg, llvmType + "*"));
         } else {
             LLVMGenerator.declareGlobalMatrix(varName, llvmType, init);
             globalVars.put(varName, new VariableInfo("@" + varName, llvmType));
         }
     }
     
     private long getMatrixSize(List<Integer> dims, String elementType) {
         long elements = dims.stream().reduce(1, (a, b) -> a * b);
         int elementSize = elementType.equals("i32") ? 4 : 
                          elementType.equals("float") ? 4 : 
                          elementType.equals("double") ? 8 : 4;
         return elements * elementSize;
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

        if (llvmType.startsWith("%struct.")) {
            // Allocate struct memory
            String ptrReg = "%" + varName;
            LLVMGenerator.emit(ptrReg + " = alloca " + llvmType);
            
            // Store in current scope
            Scope currentScope = scopes.peek();
            currentScope.variables.put(varName, new VariableInfo(ptrReg, llvmType + "*"));
        }else if (inFunction) {
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
            Scope currentScope = scopes.peek();
            currentScope.variables.put(varName, new VariableInfo(localPtr, llvmType));
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
        scopes.push(new Scope(ScopeType.FUNCTION)); // Function's scope
        inFunction = true;

        // Retrieve the return type and map it to the corresponding LLVM type.
        String type = "void";
        if (ctx.type() != null) {
            type = ctx.type().getText();
        }
        String returnType = mapType(type);
        // Retrieve the function name.
        String funcName = ctx.ID().getText();

        // record it for calls
        functionReturnTypes.put(funcName, returnType);

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

                // Record the local variable in the stack
                Scope currentScope = scopes.peek();
                currentScope.variables.put(paramName, new VariableInfo(localPtr, paramLLVMType));
            }
        }
    }

    @Override
    public void exitFunctionDefinition(CmashParser.FunctionDefinitionContext ctx) {
        // if the function is declared void…
        if (functionReturnTypes.get(ctx.ID().getText()).equals("void")) {
            LLVMGenerator.emit("ret void");
        }
        
        // End the function definition (emit the closing brace and a blank line).
        LLVMGenerator.endFunction();
    
        // Exit the function scope: reset the flag and pop the local stack symbol table.
        while (!scopes.isEmpty() && scopes.peek().type != ScopeType.FUNCTION) {
            scopes.pop();
        }
        if (!scopes.isEmpty()) scopes.pop();
        inFunction = false;
    }

    @Override
    public void enterStructDefinition(CmashParser.StructDefinitionContext ctx) {
        currentStructName = ctx.ID().getText();
        structs.put(currentStructName, new StructInfo());
        scopes.push(new Scope(ScopeType.STRUCT));  // Use STRUCT scope
    }

    @Override
    public void exitStructDefinition(CmashParser.StructDefinitionContext ctx) {
        // Emit LLVM struct type definition
        StructInfo info = structs.get(currentStructName);
        String llvmType = "%struct." + currentStructName + " = type { " +
            info.getMemberTypes().stream().collect(Collectors.joining(", ")) + " }";
        LLVMGenerator.emitGlobal(llvmType);
        
        scopes.pop();  // Exit STRUCT scope
        currentStructName = null;
    }

    @Override
    public void exitCompoundStruct(CmashParser.CompoundStructContext ctx) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void exitStructMember(CmashParser.StructMemberContext ctx) {
        String memberName = ctx.ID().getText();
        String memberType = mapType(ctx.type().getText());
        structs.get(currentStructName).addMember(memberName, memberType);
        
        // Add to STRUCT scope
        Scope currentScope = scopes.peek();
        currentScope.variables.put(memberName, new VariableInfo("", memberType)); // Pointer not needed here
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

    @Override public void enterNumericalType(CmashParser.NumericalTypeContext ctx) { 
        //throw new UnsupportedOperationException("Not supported yet.");
    }

	@Override public void exitNumericalType(CmashParser.NumericalTypeContext ctx) { 
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void exitParameters(CmashParser.ParametersContext ctx) {
        List<ValueAndType> args = new ArrayList<>();

        // Case A: grammar production “parameters : parameter (',' parameter)*”
        if (!ctx.parameter().isEmpty()) {
            for (CmashParser.ParameterContext pCtx : ctx.parameter()) {
                ValueAndType vat = values.get(pCtx);
                if (vat != null) args.add(vat);
            }
        }
        // Case B: your fallback “| ID (',' ID)*” 
        else {
            for (TerminalNode idNode : ctx.ID()) {
                String name = idNode.getText();
                VariableInfo info = inFunction
                    ? getVariableInfo(name)
                    : globalVars.get(name);
                if (info == null) throw new RuntimeException(
                    "Undeclared var in call: " + name);

                // load it
                String tmp = LLVMGenerator.newTempReg();
                LLVMGenerator.emit(tmp
                    + " = load " 
                    + info.llvmType + ", " 
                    + info.llvmType + "* " 
                    + info.pointerName);
                args.add(new ValueAndType(tmp, info.llvmType));
            }
        }

        paramValues.put(ctx, args);
    }

    @Override
    public void exitParameter(CmashParser.ParameterContext ctx) {
        if (ctx.ID() != null) {
            String name = ctx.ID().getText();
            VariableInfo info = inFunction
                ? getVariableInfo(name)
                : globalVars.get(name);

            if (info != null) {
                String tmp = LLVMGenerator.newTempReg();
                LLVMGenerator.emit(tmp
                    + " = load "
                    + info.llvmType + ", "
                    + info.llvmType + "* "
                    + info.pointerName);
                values.put(ctx, new ValueAndType(tmp, info.llvmType));
                return;
            }
        }

        // Fallback: zero of i32
        values.put(ctx, new ValueAndType("0", "i32"));
    }

    private boolean isFunctionBody(CmashParser.CompoundStatementContext ctx) {
        return ctx.getParent() instanceof CmashParser.FunctionDefinitionContext;
    }

    @Override
    public void enterCompoundStatement(CmashParser.CompoundStatementContext ctx)
    {
        if (!isFunctionBody(ctx)) { // Avoid duplicating function scope
            scopes.push(new Scope(ScopeType.BLOCK)); // Block scope marker
        }
    }

    @Override
    public void exitCompoundStatement(CmashParser.CompoundStatementContext ctx) {

        // Push the variables off the stack
        while (!scopes.isEmpty() && scopes.peek().type != ScopeType.BLOCK) {
            scopes.pop();
        }
        if (!scopes.isEmpty()) scopes.pop();

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

        // While loop
        if (ctx.getParent() instanceof CmashParser.IterationStatementContext) {
            LoopLabels L = loopLabels.get(ctx.getParent());
            LLVMGenerator.emit("br label %" + L.condLabel); // Jump back to condition
        }

        // If statement
        if (ctx.getParent() instanceof CmashParser.SelectionStatementContext) {
            CmashParser.SelectionStatementContext ifCtx = (CmashParser.SelectionStatementContext) ctx.getParent();
            SelectionLabels labels = selectionLabels.get(ifCtx);

            // Is this the 'then' statement? (ctx.statement(0))
            if (ifCtx.statement(0) == ctx) {
                LLVMGenerator.emit("; THEN block ends for " + labels.thenLabel);
                // After the 'then' block, unconditionally jump to the 'merge' label.
                LLVMGenerator.emit("br label %" + labels.mergeLabel);

                // If there's an ELSE part, emit the 'else' label now.
                // The code for the 'else' block (ifCtx.statement(1)) will follow naturally.
                if (ifCtx.ELSE() != null) {
                    LLVMGenerator.emit(labels.elseLabel + ":");
                    LLVMGenerator.emit("; ELSE block starts for " + labels.elseLabel);
                }
            }
            // Is this the 'else' statement? (ctx.statement(1))
            // (This check also handles 'else if' because the 'else if' is parsed as an 'if' statement
            // being the single statement of the 'else' part of the outer 'if')
            else if (ifCtx.ELSE() != null && ifCtx.statement(1) == ctx) {
                LLVMGenerator.emit("; ELSE block ends for " + labels.elseLabel);
                // After the 'else' block, unconditionally jump to the 'merge' label.
                LLVMGenerator.emit("br label %" + labels.mergeLabel);
            }
        }
    }

    @Override
    public void exitExpressionStatement(CmashParser.ExpressionStatementContext ctx) {
        // Retrieve the value computed for the expression child.
        ValueAndType exprValue = values.get(ctx.expression());
    
        // Optionally, you could emit a debug comment.
        LLVMGenerator.emit("; Evaluated expression statement, result in " + exprValue.register);
    
        // Propagate the computed expression result for this statement.
        values.put(ctx, exprValue);
    }

    @Override
    public void exitExpression(CmashParser.ExpressionContext ctx) {
        // First check for a unary negation ("!" expression).
        if (ctx.getChildCount() == 2 && ctx.getChild(0).getText().equals("!")) {
            ValueAndType operandVAT = values.get(ctx.expression(0));
            String resultReg = LLVMGenerator.newTempReg();
            // Emit code to flip the i1 value: NOT x is computed as xor i1 x, 1.
            LLVMGenerator.emit(resultReg + " = xor i1 " + operandVAT.register + ", 1");
            values.put(ctx, new ValueAndType(resultReg, "i1"));
            return;
        }

        // For binary operators (&&, ||, ^, etc.) or literal and variable cases.
        if (ctx.getChildCount() >= 3) {
            String op = ctx.getChild(1).getText();
            if (op.equals("&&") || op.equals("||") || op.equals("^")) {
                // Retrieve the left and right operands.
                ValueAndType leftVAT = values.get(ctx.expression(0));
                ValueAndType rightVAT = values.get(ctx.expression(1));
                
                // Track current block.
                String currentBlockLabel = LLVMGenerator.currentBlock;

                // For XOR, we assume the values are booleans (i1). No short-circuit is required.
                if (op.equals("^")) {
                    String resultReg = LLVMGenerator.newTempReg();
                    // Emit the XOR instruction for booleans.
                    LLVMGenerator.emit(resultReg + " = xor i1 " + leftVAT.register + ", " + rightVAT.register);
                    values.put(ctx, new ValueAndType(resultReg, "i1"));
                    //System.out.println(";" + "i1 " + resultReg);
                    return;
                }
                
                if (op.equals("&&")) {
                    // ----- Logical AND short-circuiting -----
                    // Create labels for the right-hand side evaluation and the merge block.
                    String rhsLabel = LLVMGenerator.newLabel();
                    String mergeLabel = LLVMGenerator.newLabel();
                    
                    // Emit a conditional branch:
                    LLVMGenerator.emit("br i1 " + leftVAT.register + ", label %" + rhsLabel + ", label %" + mergeLabel);
                    
                    // Mark the right-hand side block.
                    LLVMGenerator.emitBlock(rhsLabel);
                    LLVMGenerator.emit("br label %" + mergeLabel);
                    
                    // Emit the merge block.
                    LLVMGenerator.emitBlock(mergeLabel);
                    String resultReg = LLVMGenerator.newTempReg();

                    LLVMGenerator.emit(resultReg + " = phi i1 [ 0, %" + currentBlockLabel + " ], [ " + rightVAT.register + ", %" + rhsLabel + " ]");
                    values.put(ctx, new ValueAndType(resultReg, "i1"));
                    //System.out.println(";" + "i1 " + resultReg);
                    return;
                } else if (op.equals("||")) {
                    // ----- Logical OR short-circuiting -----
                    String rhsLabel = LLVMGenerator.newLabel();
                    String mergeLabel = LLVMGenerator.newLabel();
                    
                    // For logical OR, if the left operand is true, we already have a true value.
                    LLVMGenerator.emit("br i1 " + leftVAT.register + ", label %" + mergeLabel + ", label %" + rhsLabel);
                    
                    // Emit the right-hand side block.
                    LLVMGenerator.emitBlock(rhsLabel);
                    LLVMGenerator.emit("br label %" + mergeLabel);
                    
                    // Emit the merge block.
                    LLVMGenerator.emitBlock(mergeLabel);
                    String resultReg = LLVMGenerator.newTempReg();

                    LLVMGenerator.emit(resultReg + " = phi i1 [ 1, %" + currentBlockLabel + " ], [ " + rightVAT.register + ", %" + rhsLabel + " ]");
                    values.put(ctx, new ValueAndType(resultReg, "i1"));
                    //System.out.println(";" + "i1 " + resultReg);
                    return;
                }
            }
        }

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
            //System.err.println("\t" + ctx.getText());
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
            } else if (getVariableInfo(text) != null) {
                // If the text is a variable name, retrieve its LLVM representation.
                VariableInfo varInfo = getVariableInfo(text);
                result = new ValueAndType(LLVMGenerator.loadValue(varInfo.llvmType, varInfo.pointerName), varInfo.llvmType);
            } else {
                result = new ValueAndType("0", "i32");
            }
        }
        
        //System.out.println(";" + result.llvmType + " " + result.register);
        values.put(ctx, result);

        // While loop 
        if (ctx.getParent() instanceof CmashParser.IterationStatementContext) {
            LoopLabels L = loopLabels.get(ctx.getParent());
            ValueAndType condVAT = values.get(ctx);
    
            // Emit branch based on condition
            LLVMGenerator.emit("br i1 " + condVAT.register 
                             + ", label %" + L.bodyLabel 
                             + ", label %" + L.endLabel);
            
            // Start the body block
            LLVMGenerator.emitBlock(L.bodyLabel);
        }

        // If statemt
        if (ctx.getParent() instanceof CmashParser.SelectionStatementContext) {
            CmashParser.SelectionStatementContext ifCtx = (CmashParser.SelectionStatementContext) ctx.getParent();
            // Ensure it's THE expression for this if, not one nested deeper
            if (ifCtx.expression() == ctx) {
                SelectionLabels labels = selectionLabels.get(ifCtx);
                ValueAndType condVAT = values.get(ctx); // Get the result of the condition
                String condReg = condVAT.register;

                LLVMGenerator.emit("; Condition for IF evaluated: " + condReg + " (" + ctx.getText() + ")");
                // Emit the conditional branch using the helper
                LLVMGenerator.emitConditionalBranch(condReg, labels);

                // Emit the 'then' label. Code for the 'then' block will follow naturally.
                LLVMGenerator.emit(labels.thenLabel + ":");
                LLVMGenerator.emit("; THEN block starts for " + labels.thenLabel);
            }
        }

        if (ctx.fieldAccess() != null) {
            // Get the computed pointer from fieldAccess
            ValueAndType ptrVAT = values.get(ctx.fieldAccess());
            
            // Load the value from the struct field
            String tmpReg = LLVMGenerator.newTempReg();
            LLVMGenerator.emit(tmpReg + " = load " + ptrVAT.llvmType + ", " + ptrVAT.llvmType + "* " + ptrVAT.register);
            values.put(ctx, new ValueAndType(tmpReg, ptrVAT.llvmType));
            return;
        }
    }

    @Override
    public void exitAssignment(CmashParser.AssignmentContext ctx) {
        // Case 1: Assignment to a variable using an ID.
        if (ctx.ID() != null) {
            String varName = ctx.ID().getText();
            // Evaluate the right-hand side expression.
            ValueAndType rhs = values.get(ctx.expression());
        
            // Look up the variable pointer in localVars (if inside a function) or globalVars.
            VariableInfo varInfo = inFunction ? getVariableInfo(varName) : globalVars.get(varName);
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
        // Case 3: arrays
        else if (ctx.arrayAccess() != null) {
            // Get the computed pointer to the array element
            ValueAndType elementPtrVAT = values.get(ctx.arrayAccess());
            // Get the RHS value
            ValueAndType rhsVAT = values.get(ctx.expression());
            
            // Emit store instruction: <element-type> <rhs-value>, <element-type>* <pointer>
            LLVMGenerator.emit("store " + rhsVAT.llvmType + " " + rhsVAT.register + ", " + 
                              rhsVAT.llvmType + "* " + elementPtrVAT.register);
            
            // Propagate the RHS value as the result
            values.put(ctx, rhsVAT);
        }
        // Case 4: Fallback to equality expression
        else {
            values.put(ctx, values.get(ctx.equality()));
        }
    }

    @Override
    public void exitEquality(CmashParser.EqualityContext ctx) {
        // If there is only one relational expression, simply propagate its value.
        if (ctx.relational().size() == 1) {
            values.put(ctx, values.get(ctx.relational(0)));
        }
        else{
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

        if (ctx.getParent() instanceof CmashParser.LoopStatementContext loop) {
            LoopLabels L = loopLabels.get(loop);
            ValueAndType condVat = values.get(ctx);
            // Emit branch based on condition
            LLVMGenerator.emit("br i1 " + condVat.register
                             + ", label %" + L.bodyLabel
                             + ", label %" + L.endLabel);
            // Start the body block
            LLVMGenerator.emitBlock(L.bodyLabel);
        }
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
        List<TerminalNode> ids = ctx.ID();
        String baseVarName = ids.get(0).getText();
        
        // Get base variable
        VariableInfo baseVar = getVariableInfo(baseVarName);
        if (baseVar == null) {
            System.err.println("Error: " + baseVarName + " not declared");
            values.put(ctx, new ValueAndType("0", "i32"));
            return;
        }

        // Get struct type (e.g., "%struct.Person" → "Person")
        String structType = baseVar.llvmType.replaceAll("\\*", "");
        String structName = structType.substring("%struct.".length());

        StructInfo struct = structs.get(structName);
        if (struct == null) {
            System.err.println("Error: Struct " + structName + " undefined");
            values.put(ctx, new ValueAndType("0", "i32"));
            return;
        }

        // Generate GEP for each field
        String currentPtr = baseVar.pointerName;
        for (int i = 1; i < ids.size(); i++) {
            String fieldName = ids.get(i).getText();
            int fieldIndex = struct.getFieldIndex(fieldName);
            
            String gepReg = LLVMGenerator.newTempReg();
            LLVMGenerator.emit(
                gepReg + " = getelementptr inbounds %struct." + structName + 
                ", %struct." + structName + "* " + currentPtr + ", i32 0, i32 " + fieldIndex
            );
            currentPtr = gepReg;
        }

        values.put(ctx, new ValueAndType(currentPtr, struct.getMemberType(ids.get(1).getText())));
    }

    @Override
    public void exitFunctionCall(CmashParser.FunctionCallContext ctx) {
        // For a simple function call, assume the first token is the function name.
        String funcName = ctx.ID().getText();
    
        // look up the real return type (default to i32 if unknown)
        String retType = functionReturnTypes.getOrDefault(funcName, "i32");

        // pull the list you built in exitParameters:
        List<ValueAndType> args = ctx.parameters() == null
            ? Collections.emptyList()
            : paramValues.getOrDefault(ctx.parameters(),
                                       Collections.emptyList());
    
        // build “i32 5, i32 9, …”
        String paramSig = args.stream()
            .map(vat -> vat.llvmType + " " + vat.register)
            .collect(Collectors.joining(", "));

        if (!retType.equals("void")) {
            String resultReg = LLVMGenerator.newTempReg();
            LLVMGenerator.emit(resultReg
                + " = call " + retType
                + " @" + funcName
                + "(" + paramSig + ")");
            values.put(ctx, new ValueAndType(resultReg, retType));
        } else {
            LLVMGenerator.emit("call " + retType
                + " @" + funcName
                + "(" + paramSig + ")");
            values.put(ctx, new ValueAndType("", "void"));
        }
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
            VariableInfo varInfo = inFunction ? getVariableInfo(varName) : globalVars.get(varName);
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
        if (ctx.INT() != null) {
            values.put(ctx, new ValueAndType(ctx.INT().getText(), "i32"));
        } else if (ctx.FLOAT() != null) {
            String floatText = ctx.FLOAT().getText();
            // Remove trailing 'f' or 'F'
            if (floatText.endsWith("f") || floatText.endsWith("F")) {
                floatText = floatText.substring(0, floatText.length() - 1);
            }
            float value = Float.parseFloat(floatText);
            int bits = Float.floatToIntBits(value);
            String formatted = "0x" + String.format("%08X", bits);
            values.put(ctx, new ValueAndType(formatted, "float"));
        } else if (ctx.DOUBLE() != null) {
            String doubleText = ctx.DOUBLE().getText();
            values.put(ctx, new ValueAndType(doubleText, "double"));
        }
    }

    @Override
    public void exitArrayAccess(CmashParser.ArrayAccessContext ctx) {
        String varName = ctx.ID().getText();
        VariableInfo varInfo = inFunction ? getVariableInfo(varName) : globalVars.get(varName);
        
        if (varInfo == null) {
            System.err.println("Error: variable " + varName + " is not declared.");
            return;
        }

        // Collect all indices (e.g., [1][2][3] -> ["1", "2", "3"])
        List<String> indices = ctx.INT().stream()
            .map(TerminalNode::getText)
            .collect(Collectors.toList());

        // Build GEP indices (start with 0 for the base pointer)
        String gepIndices = "i32 0";
        for (String index : indices) {
            gepIndices += ", i32 " + index;
        }

        // Construct GEP instruction
        String elementPtr = LLVMGenerator.newTempReg();
        String gep = "getelementptr inbounds " + varInfo.llvmType.replace("*", "") + 
                    ", " + varInfo.llvmType + " " + varInfo.pointerName + 
                    ", " + gepIndices;

        LLVMGenerator.emit(elementPtr + " = " + gep);
        
        // Infer the element type (simplified example; adjust based on your type system)
        String elementType = varInfo.llvmType.replaceAll("\\[.*\\]", "").trim();
        values.put(ctx, new ValueAndType(elementPtr, elementType));
    }

    @Override public void enterMatrixAccess(CmashParser.MatrixAccessContext ctx) { 
        throw new UnsupportedOperationException("Not supported yet.");
    }

	@Override public void exitMatrixAccess(CmashParser.MatrixAccessContext ctx) { 
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void enterSelectionStatement(CmashParser.SelectionStatementContext ctx) {
        // Create labels. If an ELSE exists, pass true.
        SelectionLabels labels = LLVMGenerator.newSelectionLabels(ctx.ELSE() != null);
        // Store them in the map for retrieval by this context and its relevant children.
        selectionLabels.put(ctx, labels);

        // Debugging comment
        LLVMGenerator.emit("; Entering IF construct related to labels: then=" + labels.thenLabel +
                           (labels.elseLabel != null ? " else=" + labels.elseLabel : "") +
                           " merge=" + labels.mergeLabel);
        // DO NOT emit conditional branch or then-label yet.
        // The condition expression (ctx.expression()) will be visited next.
    }

    @Override
    public void exitSelectionStatement(CmashParser.SelectionStatementContext ctx) {
        SelectionLabels labels = selectionLabels.get(ctx);

        // All branching logic and block-specific jumps should have been emitted by now.
        // The only thing left is to emit the final 'merge' label.
        LLVMGenerator.emit(labels.mergeLabel + ":");
        LLVMGenerator.emit("; IF construct ends, merged at " + labels.mergeLabel);

        // Clean up the labels for this context
        selectionLabels.remove(ctx);

        // A selection statement itself doesn't produce a value.
        values.put(ctx, new ValueAndType("", "void"));
    }
    
    @Override
    public void enterIterationStatement(CmashParser.IterationStatementContext ctx) {
        scopes.push(new Scope(ScopeType.LOOP));
    
        // Generate labels (init/update are unused for while loops)
        LoopLabels L = new LoopLabels(
            "",                             // initLabel (unused)
            LLVMGenerator.newLabel(),       // condLabel
            LLVMGenerator.newLabel(),       // bodyLabel
            "",                             // updateLabel (unused)
            LLVMGenerator.newLabel()        // endLabel
        );
        loopLabels.put(ctx, L);
    
        // Jump to condition block
        LLVMGenerator.emit("br label %" + L.condLabel);
        LLVMGenerator.emitBlock(L.condLabel);
    }

    @Override
    public void exitIterationStatement(CmashParser.IterationStatementContext ctx) {
        LoopLabels L = loopLabels.get(ctx);
    
        // Emit end block
        LLVMGenerator.emitBlock(L.endLabel);
        loopLabels.remove(ctx);
    
        // Pop LOOP scope
        while (!scopes.isEmpty() && scopes.peek().type != ScopeType.LOOP) scopes.pop();
        if (!scopes.isEmpty()) scopes.pop();
    }

    @Override
    public void enterLoopStatement(CmashParser.LoopStatementContext ctx) {
        // 1) push a LOOP scope so locals in the init/declaration don't escape
        scopes.push(new Scope(ScopeType.LOOP));

        // 2) generate 4 labels
        LoopLabels L = new LoopLabels(
            LLVMGenerator.newLabel(),    // init
            LLVMGenerator.newLabel(),    // cond
            LLVMGenerator.newLabel(),    // body
            LLVMGenerator.newLabel(),    // update
            LLVMGenerator.newLabel()     // end
        );
        loopLabels.put(ctx, L);
    }

    @Override
    public void exitLoopStatement(CmashParser.LoopStatementContext ctx) {
        LoopLabels ll = loopLabels.get(ctx);

        // — close body → jump to update
        LLVMGenerator.emit("br label %" + ll.updateLabel);

        // — open update block
        LLVMGenerator.emitBlock(ll.updateLabel);
        // emit your “Iter = Iter + 1” IR here
        values.get(ctx.expression());
        // loop back to cond
        LLVMGenerator.emit("br label %" + ll.condLabel);

        // — open end block
        LLVMGenerator.emitBlock(ll.endLabel);

        // pop your LOOP scope…
        while (!scopes.isEmpty() && scopes.peek().type != ScopeType.LOOP) scopes.pop();
        if (!scopes.isEmpty()) scopes.pop();
    }

    @Override
    public void enterIoStatement(CmashParser.IoStatementContext ctx) {
        LLVMGenerator.emit("; Entering IO statement");
    }

    private void generateMatrixPrintLoops(VariableInfo matrixVar, String matrixType, List<Integer> dims, String elementType) {
        String ptrReg = matrixVar.pointerName;
        List<String> indices = new ArrayList<>();
        List<String> loopLabels = new ArrayList<>();
    
        // Generate GEP indices and loop labels for each dimension
        for (int i = 0; i < dims.size(); i++) {
            String idxReg = LLVMGenerator.newTempReg();
            String loopStart = LLVMGenerator.newLabel();
            String loopEnd = LLVMGenerator.newLabel();
            loopLabels.add(loopStart);
            loopLabels.add(loopEnd);
    
            // Initialize index variable
            LLVMGenerator.emit(idxReg + " = alloca i32");
            LLVMGenerator.emit("store i32 0, i32* " + idxReg);
            indices.add(idxReg);
    
            // Loop header
            LLVMGenerator.emit("br label %" + loopStart);
            LLVMGenerator.emit(loopStart + ":");
            String currentIdx = LLVMGenerator.loadValue("i32", idxReg);
            String cmpReg = LLVMGenerator.newTempReg();
            LLVMGenerator.emit(cmpReg + " = icmp slt i32 " + currentIdx + ", " + dims.get(i));
            String exitLabel = (i == dims.size() - 1) ? loopLabels.get(loopLabels.size() - 1) : loopLabels.get(loopLabels.size() - 2);
            LLVMGenerator.emit("br i1 " + cmpReg + ", label %" + loopLabels.get(loopLabels.size() - 2) + ", label %" + exitLabel);
        }
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
                } else if (arg.llvmType.equals("i1")) {
                    formatStr = "@strb";  // use boolean format
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
                } else if (arg.llvmType.equals("i1")) {
                    // Use a select instruction to pick the appropriate string based on the i1 value.
                    String selectReg = LLVMGenerator.newTempReg();
                    LLVMGenerator.emit(selectReg + " = select i1 " + arg.register +
                                        ", i8* getelementptr inbounds ([5 x i8], [5 x i8]* @trueStr, i32 0, i32 0)," +
                                        " i8* getelementptr inbounds ([6 x i8], [6 x i8]* @falseStr, i32 0, i32 0)");

                    // Use the string format (@strs) to print the string.
                    callInstr = "call i32 (i8*, ...) @printf(" +
                                "i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strs, i32 0, i32 0), " +
                                "i8* " + selectReg + ")";
                } else {
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
            // Handle read statement
            String varName = ctx.ID().getText();
            LLVMGenerator.emit("; Read token " + varName + "\n");
            ValueAndType register;
            VariableInfo varInfo;
            if (getVariableInfo(varName) != null) {
                // If the text is a variable name, retrieve its LLVM representation.
                varInfo = getVariableInfo(varName);
                register = new ValueAndType(LLVMGenerator.loadValue(varInfo.llvmType, varInfo.pointerName), varInfo.llvmType);
            }
            else {
                LLVMGenerator.emit("; Error: Variable '" + varName + "' not declared");
                return;
            }

            String formatStr;
            String gepSize;
            String argType;

            switch (register.llvmType) {
                case "i32":
                    formatStr = "@strd_in";
                    gepSize = "3";
                    argType = "i32*";
                    break;
                case "float":
                    formatStr = "@strf_in";
                    gepSize = "3";
                    argType = "float*";
                    break;
                case "double":
                    formatStr = "@strlf_in";
                    gepSize = "4";
                    argType = "double*";
                    break;
                case "i8*":
                    formatStr = "@strs_in";
                    gepSize = "3";
                    argType = "i8*";
                    break;
                default:
                    LLVMGenerator.emit("; Error: Unsupported type '" + register.llvmType + "' for read");
                    return;
            }

            // Generate the scanf call
            String callInstr = String.format(
                "call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([%s x i8], [%s x i8]* %s, i32 0, i32 0), %s %s)",
                gepSize, gepSize, formatStr, argType, varInfo.pointerName
            );
            LLVMGenerator.emit(callInstr);
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
