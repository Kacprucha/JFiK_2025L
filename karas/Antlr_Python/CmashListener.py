# Generated from Cmash.g4 by ANTLR 4.13.2
from antlr4 import *
if "." in __name__:
    from .CmashParser import CmashParser
else:
    from CmashParser import CmashParser

# This class defines a complete listener for a parse tree produced by CmashParser.
class CmashListener(ParseTreeListener):

    # Enter a parse tree produced by CmashParser#program.
    def enterProgram(self, ctx:CmashParser.ProgramContext):
        pass

    # Exit a parse tree produced by CmashParser#program.
    def exitProgram(self, ctx:CmashParser.ProgramContext):
        pass


    # Enter a parse tree produced by CmashParser#declaration.
    def enterDeclaration(self, ctx:CmashParser.DeclarationContext):
        pass

    # Exit a parse tree produced by CmashParser#declaration.
    def exitDeclaration(self, ctx:CmashParser.DeclarationContext):
        pass


    # Enter a parse tree produced by CmashParser#variableList.
    def enterVariableList(self, ctx:CmashParser.VariableListContext):
        pass

    # Exit a parse tree produced by CmashParser#variableList.
    def exitVariableList(self, ctx:CmashParser.VariableListContext):
        pass


    # Enter a parse tree produced by CmashParser#variable.
    def enterVariable(self, ctx:CmashParser.VariableContext):
        pass

    # Exit a parse tree produced by CmashParser#variable.
    def exitVariable(self, ctx:CmashParser.VariableContext):
        pass


    # Enter a parse tree produced by CmashParser#functionDefinition.
    def enterFunctionDefinition(self, ctx:CmashParser.FunctionDefinitionContext):
        pass

    # Exit a parse tree produced by CmashParser#functionDefinition.
    def exitFunctionDefinition(self, ctx:CmashParser.FunctionDefinitionContext):
        pass


    # Enter a parse tree produced by CmashParser#structDefinition.
    def enterStructDefinition(self, ctx:CmashParser.StructDefinitionContext):
        pass

    # Exit a parse tree produced by CmashParser#structDefinition.
    def exitStructDefinition(self, ctx:CmashParser.StructDefinitionContext):
        pass


    # Enter a parse tree produced by CmashParser#compoundStruct.
    def enterCompoundStruct(self, ctx:CmashParser.CompoundStructContext):
        pass

    # Exit a parse tree produced by CmashParser#compoundStruct.
    def exitCompoundStruct(self, ctx:CmashParser.CompoundStructContext):
        pass


    # Enter a parse tree produced by CmashParser#structMember.
    def enterStructMember(self, ctx:CmashParser.StructMemberContext):
        pass

    # Exit a parse tree produced by CmashParser#structMember.
    def exitStructMember(self, ctx:CmashParser.StructMemberContext):
        pass


    # Enter a parse tree produced by CmashParser#type.
    def enterType(self, ctx:CmashParser.TypeContext):
        pass

    # Exit a parse tree produced by CmashParser#type.
    def exitType(self, ctx:CmashParser.TypeContext):
        pass


    # Enter a parse tree produced by CmashParser#parameters.
    def enterParameters(self, ctx:CmashParser.ParametersContext):
        pass

    # Exit a parse tree produced by CmashParser#parameters.
    def exitParameters(self, ctx:CmashParser.ParametersContext):
        pass


    # Enter a parse tree produced by CmashParser#parameter.
    def enterParameter(self, ctx:CmashParser.ParameterContext):
        pass

    # Exit a parse tree produced by CmashParser#parameter.
    def exitParameter(self, ctx:CmashParser.ParameterContext):
        pass


    # Enter a parse tree produced by CmashParser#compoundStatement.
    def enterCompoundStatement(self, ctx:CmashParser.CompoundStatementContext):
        pass

    # Exit a parse tree produced by CmashParser#compoundStatement.
    def exitCompoundStatement(self, ctx:CmashParser.CompoundStatementContext):
        pass


    # Enter a parse tree produced by CmashParser#statement.
    def enterStatement(self, ctx:CmashParser.StatementContext):
        pass

    # Exit a parse tree produced by CmashParser#statement.
    def exitStatement(self, ctx:CmashParser.StatementContext):
        pass


    # Enter a parse tree produced by CmashParser#expressionStatement.
    def enterExpressionStatement(self, ctx:CmashParser.ExpressionStatementContext):
        pass

    # Exit a parse tree produced by CmashParser#expressionStatement.
    def exitExpressionStatement(self, ctx:CmashParser.ExpressionStatementContext):
        pass


    # Enter a parse tree produced by CmashParser#expression.
    def enterExpression(self, ctx:CmashParser.ExpressionContext):
        pass

    # Exit a parse tree produced by CmashParser#expression.
    def exitExpression(self, ctx:CmashParser.ExpressionContext):
        pass


    # Enter a parse tree produced by CmashParser#assignment.
    def enterAssignment(self, ctx:CmashParser.AssignmentContext):
        pass

    # Exit a parse tree produced by CmashParser#assignment.
    def exitAssignment(self, ctx:CmashParser.AssignmentContext):
        pass


    # Enter a parse tree produced by CmashParser#equality.
    def enterEquality(self, ctx:CmashParser.EqualityContext):
        pass

    # Exit a parse tree produced by CmashParser#equality.
    def exitEquality(self, ctx:CmashParser.EqualityContext):
        pass


    # Enter a parse tree produced by CmashParser#relational.
    def enterRelational(self, ctx:CmashParser.RelationalContext):
        pass

    # Exit a parse tree produced by CmashParser#relational.
    def exitRelational(self, ctx:CmashParser.RelationalContext):
        pass


    # Enter a parse tree produced by CmashParser#additive.
    def enterAdditive(self, ctx:CmashParser.AdditiveContext):
        pass

    # Exit a parse tree produced by CmashParser#additive.
    def exitAdditive(self, ctx:CmashParser.AdditiveContext):
        pass


    # Enter a parse tree produced by CmashParser#multiplicative.
    def enterMultiplicative(self, ctx:CmashParser.MultiplicativeContext):
        pass

    # Exit a parse tree produced by CmashParser#multiplicative.
    def exitMultiplicative(self, ctx:CmashParser.MultiplicativeContext):
        pass


    # Enter a parse tree produced by CmashParser#fieldAccess.
    def enterFieldAccess(self, ctx:CmashParser.FieldAccessContext):
        pass

    # Exit a parse tree produced by CmashParser#fieldAccess.
    def exitFieldAccess(self, ctx:CmashParser.FieldAccessContext):
        pass


    # Enter a parse tree produced by CmashParser#primary.
    def enterPrimary(self, ctx:CmashParser.PrimaryContext):
        pass

    # Exit a parse tree produced by CmashParser#primary.
    def exitPrimary(self, ctx:CmashParser.PrimaryContext):
        pass


    # Enter a parse tree produced by CmashParser#numbers.
    def enterNumbers(self, ctx:CmashParser.NumbersContext):
        pass

    # Exit a parse tree produced by CmashParser#numbers.
    def exitNumbers(self, ctx:CmashParser.NumbersContext):
        pass


    # Enter a parse tree produced by CmashParser#selectionStatement.
    def enterSelectionStatement(self, ctx:CmashParser.SelectionStatementContext):
        pass

    # Exit a parse tree produced by CmashParser#selectionStatement.
    def exitSelectionStatement(self, ctx:CmashParser.SelectionStatementContext):
        pass


    # Enter a parse tree produced by CmashParser#iterationStatement.
    def enterIterationStatement(self, ctx:CmashParser.IterationStatementContext):
        pass

    # Exit a parse tree produced by CmashParser#iterationStatement.
    def exitIterationStatement(self, ctx:CmashParser.IterationStatementContext):
        pass


    # Enter a parse tree produced by CmashParser#loopStatement.
    def enterLoopStatement(self, ctx:CmashParser.LoopStatementContext):
        pass

    # Exit a parse tree produced by CmashParser#loopStatement.
    def exitLoopStatement(self, ctx:CmashParser.LoopStatementContext):
        pass


    # Enter a parse tree produced by CmashParser#ioStatement.
    def enterIoStatement(self, ctx:CmashParser.IoStatementContext):
        pass

    # Exit a parse tree produced by CmashParser#ioStatement.
    def exitIoStatement(self, ctx:CmashParser.IoStatementContext):
        pass


    # Enter a parse tree produced by CmashParser#jumpStatement.
    def enterJumpStatement(self, ctx:CmashParser.JumpStatementContext):
        pass

    # Exit a parse tree produced by CmashParser#jumpStatement.
    def exitJumpStatement(self, ctx:CmashParser.JumpStatementContext):
        pass


    # Enter a parse tree produced by CmashParser#printArgs.
    def enterPrintArgs(self, ctx:CmashParser.PrintArgsContext):
        pass

    # Exit a parse tree produced by CmashParser#printArgs.
    def exitPrintArgs(self, ctx:CmashParser.PrintArgsContext):
        pass



del CmashParser