package com.cmash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.antlr.v4.runtime.Token;

public class SemanticAnalyzer extends CmashBaseVisitor {

    // Stack handling variable names
    private final Stack<Map<String, Boolean>> scopeStack = new Stack<>();
    // Map variable name → its return type (as a string)
    private final Map<String,String> variableTypes = new HashMap<>();
    // Map function name → its return type (as a string)
    private final Map<String,String> functionReturnTypes = new HashMap<>();
    // Map function name → ammount of parameters as types (as a string)
    private final Map<String,List<String>> functionParamTypes = new HashMap<>(); 
    // Track parameters for the current function being analyzed
    private List<String> currentFunctionParams = new ArrayList<>();
    // Flag to record if any semantic error has been encountered.
    private boolean semanticErrorOccurred = false;
    
    public boolean hasErrors() {
        return semanticErrorOccurred;
    }

    // Helper method to check if a type represents a numeric value.
    private boolean isNumeric(String type) {
        return "int".equals(type) || "float".equals(type) || "double".equals(type);
    }

    // Initialize global scope
    public SemanticAnalyzer() {
        enterScope(); // Global scope
    }

    private void enterScope() {
        scopeStack.push(new HashMap<>());
    }
    
    private void exitScope() {
        if (!scopeStack.isEmpty()) {
            scopeStack.pop();
        }
    }
    
    private Map<String, Boolean> getCurrentScope() {
        return scopeStack.peek();
    }
    
    // Check if a variable is declared in any accessible scope
    private boolean isDeclared(String varName) {
        for (int i = scopeStack.size() - 1; i >= 0; i--) {
            if (scopeStack.get(i).containsKey(varName)) {
                return true;
            }
        }
        return false;
    }
    
    // Check if a variable is declared in the current scope (for redeclaration checks)
    private boolean isDeclaredInCurrentScope(String varName) {
        return getCurrentScope().containsKey(varName);
    }

    // Recursively evaluates the type of an expression and performs type checking.
    public String evaluateExpressionType(CmashParser.ExpressionContext ctx) {
        // --- Function-call case ---
        if (ctx.functionCall() != null && ctx.functionCall().ID() != null) {
            CmashParser.FunctionCallContext fc = ctx.functionCall();
            String fname = fc.ID().getText();
    
            // 1) Check if function exists
            if (!functionReturnTypes.containsKey(fname)) {
                reportError(fc.start, "Function '" + fname + "' is not declared.");
                return "error";
            }
    
            // 2) Get declared parameter types
            List<String> declaredParamTypes = functionParamTypes.get(fname);
            int actualParamCount = fc.parameters().ID().size(); // Get parameter count from IDs
    
            // 3) Check arity
            if (declaredParamTypes.size() != actualParamCount) {
                reportError(fc.start, "Function '" + fname + "' expects " + declaredParamTypes.size() + 
                           " arguments, but " + actualParamCount + " were provided.");
                return "error";
            }
    
            // 4) Check parameter types (assuming parameters are variable names)
            for (int i = 0; i < declaredParamTypes.size(); i++) {
                String paramName = fc.parameters().ID(i).getText();
                if (!isDeclared(paramName)) {
                    reportError(fc.start, "Parameter '" + paramName + "' is not declared.");
                }
                // Optional: Add type-checking logic if needed
            }
    
            return functionReturnTypes.get(fname);
        }
        // Base cases: Literal or identifier
        if (ctx.INT() != null) {
            return "int";
        } else if (ctx.FLOAT() != null) {
            return "float";
        } else if (ctx.DOUBLE() != null) {
            return "double";
        } else if (ctx.BOOL_LITERAL() != null) {
            return "bool";
        } else if (ctx.CHAR_LITERAL() != null) {
            return "char";  
        } else if (ctx.ID() != null && ctx.getChildCount() == 1 ) {
            String varName = ctx.ID().getText();
            if (!isDeclared(varName)) {
                reportError(ctx.start, "Variable '" + varName + "' is used but not declared.");
                return "error";
            } else if (!isDeclared(varName)) {
                reportError(ctx.start, "Variable '" + varName + "' is used but not assigned.");
                return "error";
            }

            // For now, we simply return a dummy type
            return "int";
        }
    
        // Handle unary operator case (for example, logical not '!')
        if (ctx.getChildCount() == 2) {
            String operator = ctx.getChild(0).getText();

            if (operator.equals("!")) {
                String operandType = evaluateExpressionType((CmashParser.ExpressionContext) ctx.getChild(1));
                if (!"int".equals(operandType)) {
                    reportError(ctx.start, "Operator '!' expects a boolean (int) operand, found '" + operandType + "'.");
                    return "error";
                }
                return "bool";
            }
        }
    
        // Handle binary operators 
        if (ctx.getChildCount() == 3) {
            CmashParser.ExpressionContext leftExpr = (CmashParser.ExpressionContext) ctx.getChild(0);
            String operator = ctx.getChild(1).getText();
            CmashParser.ExpressionContext rightExpr = (CmashParser.ExpressionContext) ctx.getChild(2);
        
            String leftType = evaluateExpressionType(leftExpr);
            String rightType = evaluateExpressionType(rightExpr);
        
            if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
                if (!isNumeric(leftType) || !isNumeric(rightType)) {
                    reportError(ctx.start, "Operator '" + operator + "' expects numeric operands, got '" 
                                                 + leftType + "' and '" + rightType + "'.");
                    return "error";
                }
                // Return a numeric type
                return "int";
            }
        
            // For logical binary operators
            if (operator.equals("&&") || operator.equals("||") || operator.equals("^")) {
                if (!"int".equals(leftType) || !"int".equals(rightType)) {
                    reportError(ctx.start, "Operator '" + operator + "' expects boolean (int) operands, got '" 
                                                 + leftType + "' and '" + rightType + "'.");
                    return "error";
                }
                return "bool";
            }
        }
    
        visitChildren(ctx);
        return "unknown";
    }

    public String evaluatePrimaryType (CmashParser.PrimaryContext ctx) {
        if (ctx.INT() != null) {
            return "int";
        } else if (ctx.FLOAT() != null) {
            return "float";
        } else if (ctx.DOUBLE() != null) {
            return "double";
        } else if (ctx.BOOL_LITERAL() != null) {
            return "bool";
        } else if (ctx.CHAR_LITERAL() != null) {
            return "char";  
        } else if (ctx.ID() != null && ctx.getChildCount() == 1 ) {
            String varName = ctx.ID().getText();
            if (!isDeclared(varName)) {
                reportError(ctx.start, "Variable '" + varName + "' is used but not declared.");
                return "error";
            } 

            return variableTypes.get(varName);
        }
        
        return "unknown";
    }
    
    // Report a semantic error with line/column details.
    private void reportError(Token token, String message) {
        System.err.printf("Semantic Error at line %d, col %d: %s%n",
                          token.getLine(),
                          token.getCharPositionInLine(),
                          message);
        semanticErrorOccurred = true;
    }

    @Override
    public Void visitProgram(CmashParser.ProgramContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override
    public Void visitExpression(CmashParser.ExpressionContext ctx) {
        evaluateExpressionType(ctx);
        return null;
    }

    
    // --- Variable Declarations ---
    @Override
    public Void visitCompoundStatement(CmashParser.CompoundStatementContext ctx) {
        enterScope();
        visitChildren(ctx);
        exitScope();
        return null;
    }

    // For a declaration (the 'variable' rule)
    @Override
    public Void visitVariable(CmashParser.VariableContext ctx) {
        String varName = ctx.ID().getText();
        boolean isAssigned = (ctx.expression() != null);
    
        if (isDeclaredInCurrentScope(varName)) {
            reportError(ctx.start, "Variable '" + varName + "' is redeclared.");
        } else {
            getCurrentScope().put(varName, isAssigned);
        }
    
        if (ctx.expression() != null) visit(ctx.expression());
        return null;
    }
    
    // For string declarations
    @Override
    public Void visitStringDeclaration(CmashParser.StringDeclarationContext ctx) {
        String varName = ctx.ID().getText();
        boolean isAssigned = (ctx.PLAIN_TEXT() != null);
        
        if (!isDeclared(varName)) {
            Map<String, Boolean> scope = getCurrentScope();
            scope.put(varName, isAssigned);
        } else {
            reportError(ctx.start, "Variable '" + varName + "' is redeclared.");
        }
        return null;
    }
    
    // For array declarations
    @Override
    public Void visitArrayDeclaration(CmashParser.ArrayDeclarationContext ctx) {
        String varName = ctx.ID().getText();
        // Check if there is at least one initializer value provided.
        boolean isAssigned = (ctx.values().size() > 0);
        
        if (!isDeclared(varName)) {
            Map<String, Boolean> scope = getCurrentScope();
            scope.put(varName, isAssigned);
        } else {
            reportError(ctx.start, "Variable '" + varName + "' is redeclared.");
        }
        return null;
    }
    
    // For matrix declarations
    @Override
    public Void visitMatrixDeclaration(CmashParser.MatrixDeclarationContext ctx) {
        String varName = ctx.ID().getText();
        // Check if an initializer is provided (by checking for '=' token)
        boolean isAssigned = ctx.getChildCount() > 3 && ctx.getChild(3).getText().equals("=");
        
        if (!isDeclared(varName)) {
            Map<String, Boolean> scope = getCurrentScope();
            scope.put(varName, isAssigned);
        } else {
            reportError(ctx.start, "Variable '" + varName + "' is redeclared.");
        }
        
        return null;
    }
    
    // --- Assignments ---
    
    // For assignment expressions
    @Override
    public Void visitAssignment(CmashParser.AssignmentContext ctx) {
        if (ctx.ID() != null) {
            String varName = ctx.ID().getText();
            if (!isDeclared(varName)) {
                reportError(ctx.start, "Variable '" + varName + "' is assigned but not declared.");
            } else {
                // Mark the variable as assigned
                boolean isAssigned = (ctx.expression() != null);
                getCurrentScope().put(varName, isAssigned);
            }
        }
        // Continue visiting child nodes, including the right-hand side expression.
        visitChildren(ctx);
        return null; 
    }
    
    // --- Variable Usages ---
    
    // When a variable is used as a primary expression.
    @Override
    public Void visitPrimary(CmashParser.PrimaryContext ctx) {
        if (ctx.ID() != null) {
            String varName = ctx.ID().getText();
            if (!isDeclared(varName)) {
                reportError(ctx.start, "Variable '" + varName + "' is used but not declared.");
            } else {
                // Check if assigned (simplified logic; enhance based on your needs)
                for (int i = scopeStack.size() - 1; i >= 0; i--) {
                    if (scopeStack.get(i).containsKey(varName)) {
                        if (!scopeStack.get(i).get(varName)) {
                            reportError(ctx.start, "Variable '" + varName + "' is used but not assigned.");
                        }
                        break;
                    }
                }
            }
        }
        visitChildren(ctx);
        return null;
    }

    // --- I/O Statements ---
    
    @Override
    public Void visitIoStatement(CmashParser.IoStatementContext ctx) {
        // Determine which alternative is used by inspecting the first token.
        String firstToken = ctx.getChild(0).getText();
        if (firstToken.equals("read")) {
            // read statements are assumed to have the structure: read '(' ID ')'
            String varName = ctx.getChild(2).getText();
            if (!isDeclared(varName)) {
                reportError(ctx.start, "Variable '" + varName + "' used in read statement is not declared.");
            } else {
                // Mark the variable as assigned, since we're reading a new value.
                getCurrentScope().put(varName, true);
            }
        } else if (firstToken.equals("print")) {
            visitChildren(ctx);
        }
        return null;
    }

    @Override
    public Void visitParameter(CmashParser.ParameterContext ctx) {
        String varName = ctx.ID().getText();
        if (!isDeclared(varName)) {
            Map<String, Boolean> scope = getCurrentScope();
            scope.put(varName, true); // Mark as declared and assigned
        } else {
            reportError(ctx.start, "Variable '" + varName + "' is redeclared in function parameters.");
        }
        return null;
    }

    @Override
    public Void visitFunctionDefinition(CmashParser.FunctionDefinitionContext ctx) {
        // Record function return type
        String retType = ctx.type() != null ? ctx.type().getText() : "void";
        String funcName = ctx.ID().getText();
        functionReturnTypes.put(funcName, retType);
    
        // Record parameter types
        List<String> paramTypes = new ArrayList<>();
        currentFunctionParams = new ArrayList<>();
        if (ctx.parameters() != null) {
            for (CmashParser.ParameterContext p : ctx.parameters().parameter()) {
                paramTypes.add(p.type().getText());
                currentFunctionParams.add(p.ID().getText());
            }
        }
        functionParamTypes.put(funcName, paramTypes);
    
        // Enter function scope
        enterScope();
        // Parameters are added by visitParameter; no need to add them again here
        visitChildren(ctx);
        exitScope(); // Exit function scope
    
        return null;
    }

    @Override
    public Void visitRelational(CmashParser.RelationalContext ctx) {
        if (ctx.additive(0) == null || ctx.additive(1) == null) {
            return null; // No valid relational expression
        }

        String leftType = evaluatePrimaryType(ctx.additive(0).multiplicative(0).primary(0));
        String rightType = evaluatePrimaryType(ctx.additive(1).multiplicative(0).primary(0));

        if (leftType == null || rightType == null) {
            return null; // No valid relational expression
        }

        if (leftType.equals("unknown") || rightType.equals("unknown")) {
            reportError(ctx.start, "Relational operator '" + ctx.getChild(1).getText() + "' has unknown operand types.");
            return null;
        }

        if (!leftType.equals(rightType)) {
            reportError(ctx.start, "Relational operator '" + ctx.getChild(1).getText() + "' expects operands of the same type, got '" 
                                             + leftType + "' and '" + rightType + "'.");
            return null;
        }
    
        if (!isNumeric(leftType) || !isNumeric(rightType)) {
            reportError(ctx.start, "Relational operator '" + ctx.getChild(1).getText() + "' expects numeric operands, got '" 
                                             + leftType + "' and '" + rightType + "'.");
            return null;
        }
    
        return null;
    }

    @Override
    public Void visitDeclaration (CmashParser.DeclarationContext ctx) {
        // Handle variable declarations
        String type = ctx.type().getText();
        for (CmashParser.VariableContext varCtx : ctx.variableList().variable()) {
            String varName = varCtx.ID().getText();
            if (!isDeclared(varName)) {
                Map<String, Boolean> scope = getCurrentScope();
                scope.put(varName, false); // Mark as declared but not assigned
                variableTypes.put(varName, type); // Store the variable type
            } else {
                reportError(ctx.start, "Variable '" + varName + "' is redeclared.");
            }
        }

        return null;
    }
}
