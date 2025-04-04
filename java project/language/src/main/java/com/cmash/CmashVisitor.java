package com.cmash;
// Generated from Cmash.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CmashParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CmashVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CmashParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(CmashParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(CmashParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValues(CmashParser.ValuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(CmashParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#arraySize}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArraySize(CmashParser.ArraySizeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#matrixSize}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrixSize(CmashParser.MatrixSizeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#matrixRow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrixRow(CmashParser.MatrixRowContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#stringDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringDeclaration(CmashParser.StringDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#variableList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableList(CmashParser.VariableListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(CmashParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(CmashParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#structDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDefinition(CmashParser.StructDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#compoundStruct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundStruct(CmashParser.CompoundStructContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#structMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructMember(CmashParser.StructMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(CmashParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(CmashParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(CmashParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#compoundStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundStatement(CmashParser.CompoundStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(CmashParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(CmashParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(CmashParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(CmashParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#equality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality(CmashParser.EqualityContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#relational}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational(CmashParser.RelationalContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#additive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditive(CmashParser.AdditiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#multiplicative}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicative(CmashParser.MultiplicativeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#fieldAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAccess(CmashParser.FieldAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(CmashParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(CmashParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#numbers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumbers(CmashParser.NumbersContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess(CmashParser.ArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#selectionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectionStatement(CmashParser.SelectionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterationStatement(CmashParser.IterationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#loopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStatement(CmashParser.LoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#ioStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIoStatement(CmashParser.IoStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#jumpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJumpStatement(CmashParser.JumpStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#printArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintArgs(CmashParser.PrintArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmashParser#printArg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintArg(CmashParser.PrintArgContext ctx);
}