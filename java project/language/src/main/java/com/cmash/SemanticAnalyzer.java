package com.cmash;

import java.util.HashMap;
import java.util.Map;
import org.antlr.v4.runtime.Token;

public class SemanticAnalyzer extends CmashBaseVisitor {

    // A global symbol table mapping variable names to whether they have been assigned.
    private final Map<String, Boolean> symbolTable = new HashMap<>();
    // Flag to record if any semantic error has been encountered.
    private boolean semanticErrorOccurred = false;
    
    public boolean hasErrors() {
        return semanticErrorOccurred;
    }

    // Helper method to check if a type represents a numeric value.
    private boolean isNumeric(String type) {
        return "int".equals(type) || "float".equals(type) || "double".equals(type);
    }

    // Recursively evaluates the type of an expression and performs type checking.
    public String evaluateExpressionType(CmashParser.ExpressionContext ctx) {
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
        } else if (ctx.ID() != null && ctx.getChildCount() == 1) {
            String varName = ctx.ID().getText();
            if (!symbolTable.containsKey(varName)) {
                reportError(ctx.start, "Variable '" + varName + "' is used but not declared.");
                return "error";
            } else if (!symbolTable.get(varName)) {
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
    
    // For a declaration (the 'variable' rule)
    @Override
    public Void visitVariable(CmashParser.VariableContext ctx) {
        String varName = ctx.ID().getText();
        // If an initialization expression exists, mark as assigned
        boolean isAssigned = (ctx.expression() != null);
        
        if (!symbolTable.containsKey(varName)) {
            symbolTable.put(varName, isAssigned);
        } else {
            // Optionally, report a redeclaration error here
            reportError(ctx.start, "Variable '" + varName + "' is redeclared.");
        }
        
        // Visit the initializer (if present) to check nested usages
        if (ctx.expression() != null) {
            visit(ctx.expression());
        }
        return null;
    }
    
    // For string declarations
    @Override
    public Void visitStringDeclaration(CmashParser.StringDeclarationContext ctx) {
        String varName = ctx.ID().getText();
        boolean isAssigned = (ctx.PLAIN_TEXT() != null);
        
        if (!symbolTable.containsKey(varName)) {
            symbolTable.put(varName, isAssigned);
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
        
        if (!symbolTable.containsKey(varName)) {
            symbolTable.put(varName, isAssigned);
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
        
        if (!symbolTable.containsKey(varName)) {
            symbolTable.put(varName, isAssigned);
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
            if (!symbolTable.containsKey(varName)) {
                reportError(ctx.start, "Variable '" + varName + "' is assigned but not declared.");
            } else {
                // Mark the variable as assigned
                symbolTable.put(varName, true);
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
            if (!symbolTable.containsKey(varName)) {
                reportError(ctx.start, "Variable '" + varName + "' is used but not declared.");
            } else if (!symbolTable.get(varName)) {
                reportError(ctx.start, "Variable '" + varName + "' is used but not assigned.");
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
            if (!symbolTable.containsKey(varName)) {
                reportError(ctx.start, "Variable '" + varName + "' used in read statement is not declared.");
            } else {
                // Mark the variable as assigned, since we're reading a new value.
                symbolTable.put(varName, true);
            }
        } else if (firstToken.equals("print")) {
            visitChildren(ctx);
        }
        return null;
    }
}
