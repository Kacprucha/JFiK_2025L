package com.cmash;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.cmash.CmashParser.AdditiveContext;
import com.cmash.CmashParser.ArrayAccessContext;
import com.cmash.CmashParser.ArraySizeContext;
import com.cmash.CmashParser.AssignmentContext;
import com.cmash.CmashParser.CompoundStatementContext;
import com.cmash.CmashParser.CompoundStructContext;
import com.cmash.CmashParser.DeclarationContext;
import com.cmash.CmashParser.EqualityContext;
import com.cmash.CmashParser.ExpressionContext;
import com.cmash.CmashParser.ExpressionStatementContext;
import com.cmash.CmashParser.FieldAccessContext;
import com.cmash.CmashParser.FunctionCallContext;
import com.cmash.CmashParser.FunctionDefinitionContext;
import com.cmash.CmashParser.IoStatementContext;
import com.cmash.CmashParser.IterationStatementContext;
import com.cmash.CmashParser.JumpStatementContext;
import com.cmash.CmashParser.LoopStatementContext;
import com.cmash.CmashParser.MatrixRowContext;
import com.cmash.CmashParser.MatrixSizeContext;
import com.cmash.CmashParser.MultiplicativeContext;
import com.cmash.CmashParser.NumbersContext;
import com.cmash.CmashParser.ParameterContext;
import com.cmash.CmashParser.ParametersContext;
import com.cmash.CmashParser.PrimaryContext;
import com.cmash.CmashParser.PrintArgContext;
import com.cmash.CmashParser.PrintArgsContext;
import com.cmash.CmashParser.ProgramContext;
import com.cmash.CmashParser.RelationalContext;
import com.cmash.CmashParser.SelectionStatementContext;
import com.cmash.CmashParser.StatementContext;
import com.cmash.CmashParser.StringDeclarationContext;
import com.cmash.CmashParser.StructDefinitionContext;
import com.cmash.CmashParser.StructMemberContext;
import com.cmash.CmashParser.TypeContext;
import com.cmash.CmashParser.ValueContext;
import com.cmash.CmashParser.ValuesContext;
import com.cmash.CmashParser.VariableContext;
import com.cmash.CmashParser.VariableListContext;

public class CmashCustomVisitor implements CmashVisitor  {

    @Override
    public Object visit(ParseTree tree) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public Object visitChildren(RuleNode node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitChildren'");
    }

    @Override
    public Object visitTerminal(TerminalNode node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitTerminal'");
    }

    @Override
    public Object visitErrorNode(ErrorNode node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitErrorNode'");
    }

    @Override
    public Object visitProgram(ProgramContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitProgram'");
    }

    @Override
    public Object visitDeclaration(DeclarationContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitDeclaration'");
    }

    @Override
    public Object visitValues(ValuesContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitValues'");
    }

    @Override
    public Object visitValue(ValueContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitValue'");
    }

    @Override
    public Object visitArraySize(ArraySizeContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitArraySize'");
    }

    @Override
    public Object visitMatrixSize(MatrixSizeContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitMatrixSize'");
    }

    @Override
    public Object visitMatrixRow(MatrixRowContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitMatrixRow'");
    }

    @Override
    public Object visitStringDeclaration(StringDeclarationContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitStringDeclaration'");
    }

    @Override
    public Object visitVariableList(VariableListContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitVariableList'");
    }

    @Override
    public Object visitVariable(VariableContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitVariable'");
    }

    @Override
    public Object visitFunctionDefinition(FunctionDefinitionContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitFunctionDefinition'");
    }

    @Override
    public Object visitStructDefinition(StructDefinitionContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitStructDefinition'");
    }

    @Override
    public Object visitCompoundStruct(CompoundStructContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitCompoundStruct'");
    }

    @Override
    public Object visitStructMember(StructMemberContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitStructMember'");
    }

    @Override
    public Object visitType(TypeContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitType'");
    }

    @Override
    public Object visitParameters(ParametersContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitParameters'");
    }

    @Override
    public Object visitParameter(ParameterContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitParameter'");
    }

    @Override
    public Object visitCompoundStatement(CompoundStatementContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitCompoundStatement'");
    }

    @Override
    public Object visitStatement(StatementContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitStatement'");
    }

    @Override
    public Object visitExpressionStatement(ExpressionStatementContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitExpressionStatement'");
    }

    @Override
    public Object visitExpression(ExpressionContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitExpression'");
    }

    @Override
    public Object visitAssignment(AssignmentContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitAssignment'");
    }

    @Override
    public Object visitEquality(EqualityContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitEquality'");
    }

    @Override
    public Object visitRelational(RelationalContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitRelational'");
    }

    @Override
    public Object visitAdditive(AdditiveContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitAdditive'");
    }

    @Override
    public Object visitMultiplicative(MultiplicativeContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitMultiplicative'");
    }

    @Override
    public Object visitFieldAccess(FieldAccessContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitFieldAccess'");
    }

    @Override
    public Object visitFunctionCall(FunctionCallContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitFunctionCall'");
    }

    @Override
    public Object visitPrimary(PrimaryContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitPrimary'");
    }

    @Override
    public Object visitNumbers(NumbersContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitNumbers'");
    }

    @Override
    public Object visitArrayAccess(ArrayAccessContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitArrayAccess'");
    }

    @Override
    public Object visitSelectionStatement(SelectionStatementContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitSelectionStatement'");
    }

    @Override
    public Object visitIterationStatement(IterationStatementContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitIterationStatement'");
    }

    @Override
    public Object visitLoopStatement(LoopStatementContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitLoopStatement'");
    }

    @Override
    public Object visitIoStatement(IoStatementContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitIoStatement'");
    }

    @Override
    public Object visitJumpStatement(JumpStatementContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitJumpStatement'");
    }

    @Override
    public Object visitPrintArgs(PrintArgsContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitPrintArgs'");
    }

    @Override
    public Object visitPrintArg(PrintArgContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitPrintArg'");
    }

}
