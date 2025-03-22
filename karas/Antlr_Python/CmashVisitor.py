# Generated from Cmash.g4 by ANTLR 4.13.2
from antlr4 import *
if "." in __name__:
    from .CmashParser import CmashParser
else:
    from CmashParser import CmashParser

# This class defines a complete generic visitor for a parse tree produced by CmashParser.

class CmashVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by CmashParser#program.
    def visitProgram(self, ctx:CmashParser.ProgramContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by CmashParser#declaration.
    def visitDeclaration(self, ctx:CmashParser.DeclarationContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by CmashParser#variableList.
    def visitVariableList(self, ctx:CmashParser.VariableListContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by CmashParser#variable.
    def visitVariable(self, ctx:CmashParser.VariableContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by CmashParser#functionDefinition.
    def visitFunctionDefinition(self, ctx:CmashParser.FunctionDefinitionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by CmashParser#structDefinition.
    def visitStructDefinition(self, ctx:CmashParser.StructDefinitionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by CmashParser#compoundStruct.
    def visitCompoundStruct(self, ctx:CmashParser.CompoundStructContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by CmashParser#structMember.
    def visitStructMember(self, ctx:CmashParser.StructMemberContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by CmashParser#type.
    def visitType(self, ctx:CmashParser.TypeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by CmashParser#parameters.
    def visitParameters(self, ctx:CmashParser.ParametersContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by CmashParser#parameter.
    def visitParameter(self, ctx:CmashParser.ParameterContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by CmashParser#compoundStatement.
    def visitCompoundStatement(self, ctx:CmashParser.CompoundStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by CmashParser#statement.
    def visitStatement(self, ctx:CmashParser.StatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by CmashParser#expressionStatement.
    def visitExpressionStatement(self, ctx:CmashParser.ExpressionStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by CmashParser#expression.
    def visitExpression(self, ctx:CmashParser.ExpressionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by CmashParser#assignment.
    def visitAssignment(self, ctx:CmashParser.AssignmentContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by CmashParser#equality.
    def visitEquality(self, ctx:CmashParser.EqualityContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by CmashParser#relational.
    def visitRelational(self, ctx:CmashParser.RelationalContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by CmashParser#additive.
    def visitAdditive(self, ctx:CmashParser.AdditiveContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by CmashParser#multiplicative.
    def visitMultiplicative(self, ctx:CmashParser.MultiplicativeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by CmashParser#fieldAccess.
    def visitFieldAccess(self, ctx:CmashParser.FieldAccessContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by CmashParser#primary.
    def visitPrimary(self, ctx:CmashParser.PrimaryContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by CmashParser#numbers.
    def visitNumbers(self, ctx:CmashParser.NumbersContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by CmashParser#selectionStatement.
    def visitSelectionStatement(self, ctx:CmashParser.SelectionStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by CmashParser#iterationStatement.
    def visitIterationStatement(self, ctx:CmashParser.IterationStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by CmashParser#loopStatement.
    def visitLoopStatement(self, ctx:CmashParser.LoopStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by CmashParser#ioStatement.
    def visitIoStatement(self, ctx:CmashParser.IoStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by CmashParser#jumpStatement.
    def visitJumpStatement(self, ctx:CmashParser.JumpStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by CmashParser#printArgs.
    def visitPrintArgs(self, ctx:CmashParser.PrintArgsContext):
        return self.visitChildren(ctx)



del CmashParser