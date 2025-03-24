// Generated from c:/Users/User/Desktop/Sem 8/Kompilatory/JFiK_2025L/karas/Cmash.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CmashParser}.
 */
public interface CmashListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CmashParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CmashParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmashParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CmashParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmashParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(CmashParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmashParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(CmashParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmashParser#variableList}.
	 * @param ctx the parse tree
	 */
	void enterVariableList(CmashParser.VariableListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmashParser#variableList}.
	 * @param ctx the parse tree
	 */
	void exitVariableList(CmashParser.VariableListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmashParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(CmashParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmashParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(CmashParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmashParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(CmashParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmashParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(CmashParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmashParser#structDefinition}.
	 * @param ctx the parse tree
	 */
	void enterStructDefinition(CmashParser.StructDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmashParser#structDefinition}.
	 * @param ctx the parse tree
	 */
	void exitStructDefinition(CmashParser.StructDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmashParser#compoundStruct}.
	 * @param ctx the parse tree
	 */
	void enterCompoundStruct(CmashParser.CompoundStructContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmashParser#compoundStruct}.
	 * @param ctx the parse tree
	 */
	void exitCompoundStruct(CmashParser.CompoundStructContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmashParser#structMember}.
	 * @param ctx the parse tree
	 */
	void enterStructMember(CmashParser.StructMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmashParser#structMember}.
	 * @param ctx the parse tree
	 */
	void exitStructMember(CmashParser.StructMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmashParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(CmashParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmashParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(CmashParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmashParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(CmashParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmashParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(CmashParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmashParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(CmashParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmashParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(CmashParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmashParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void enterCompoundStatement(CmashParser.CompoundStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmashParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void exitCompoundStatement(CmashParser.CompoundStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmashParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(CmashParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmashParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(CmashParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmashParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(CmashParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmashParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(CmashParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmashParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(CmashParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmashParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(CmashParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmashParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(CmashParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmashParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(CmashParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmashParser#equality}.
	 * @param ctx the parse tree
	 */
	void enterEquality(CmashParser.EqualityContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmashParser#equality}.
	 * @param ctx the parse tree
	 */
	void exitEquality(CmashParser.EqualityContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmashParser#relational}.
	 * @param ctx the parse tree
	 */
	void enterRelational(CmashParser.RelationalContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmashParser#relational}.
	 * @param ctx the parse tree
	 */
	void exitRelational(CmashParser.RelationalContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmashParser#additive}.
	 * @param ctx the parse tree
	 */
	void enterAdditive(CmashParser.AdditiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmashParser#additive}.
	 * @param ctx the parse tree
	 */
	void exitAdditive(CmashParser.AdditiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmashParser#multiplicative}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicative(CmashParser.MultiplicativeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmashParser#multiplicative}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicative(CmashParser.MultiplicativeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmashParser#fieldAccess}.
	 * @param ctx the parse tree
	 */
	void enterFieldAccess(CmashParser.FieldAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmashParser#fieldAccess}.
	 * @param ctx the parse tree
	 */
	void exitFieldAccess(CmashParser.FieldAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmashParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(CmashParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmashParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(CmashParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmashParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(CmashParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmashParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(CmashParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmashParser#numbers}.
	 * @param ctx the parse tree
	 */
	void enterNumbers(CmashParser.NumbersContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmashParser#numbers}.
	 * @param ctx the parse tree
	 */
	void exitNumbers(CmashParser.NumbersContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmashParser#selectionStatement}.
	 * @param ctx the parse tree
	 */
	void enterSelectionStatement(CmashParser.SelectionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmashParser#selectionStatement}.
	 * @param ctx the parse tree
	 */
	void exitSelectionStatement(CmashParser.SelectionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmashParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterIterationStatement(CmashParser.IterationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmashParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitIterationStatement(CmashParser.IterationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmashParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void enterLoopStatement(CmashParser.LoopStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmashParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void exitLoopStatement(CmashParser.LoopStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmashParser#ioStatement}.
	 * @param ctx the parse tree
	 */
	void enterIoStatement(CmashParser.IoStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmashParser#ioStatement}.
	 * @param ctx the parse tree
	 */
	void exitIoStatement(CmashParser.IoStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmashParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void enterJumpStatement(CmashParser.JumpStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmashParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void exitJumpStatement(CmashParser.JumpStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmashParser#printArgs}.
	 * @param ctx the parse tree
	 */
	void enterPrintArgs(CmashParser.PrintArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmashParser#printArgs}.
	 * @param ctx the parse tree
	 */
	void exitPrintArgs(CmashParser.PrintArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmashParser#printArg}.
	 * @param ctx the parse tree
	 */
	void enterPrintArg(CmashParser.PrintArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmashParser#printArg}.
	 * @param ctx the parse tree
	 */
	void exitPrintArg(CmashParser.PrintArgContext ctx);
}