import sys
from antlr4 import *
from antlr4.error.ErrorListener import ErrorListener
from CmashLexer import CmashLexer
from CmashParser import CmashParser
from CmashVisitor import CmashVisitor
import llvmlite.ir as ir
import llvmlite.binding as llvm

# Custom error listener to capture syntax and lexical errors.
class MyErrorListener(ErrorListener):
    def __init__(self):
        super(MyErrorListener, self).__init__()
        self.errors = []

    def syntaxError(self, recognizer, offendingSymbol, line, column, msg, e):
        error_message = f"Line {line}:{column} - {msg}"
        self.errors.append(error_message)

class CodeGenerator(CmashVisitor):
    def __init__(self):
        # Create a new LLVM module.
        self.module = ir.Module(name="cmash_module")
        self.builder = None
        self.func_symtab = {}  # Symbol table for variables in the current function

    def visitProgram(self, ctx: CmashParser.ProgramContext):
        # Visit each top-level construct (function, struct, declaration, etc.)
        for child in ctx.getChildren():
            self.visit(child)
        return self.module

    def visitFunctionDefinition(self, ctx: CmashParser.FunctionDefinitionContext):
        # Extract return type, function name, and parameters from the context.
        ret_type = self.getLLVMType(ctx.type())
        func_name = ctx.ID().getText()

        # Process parameters if any.
        param_list = []
        if ctx.parameters():
            for param in ctx.parameters().parameter():
                param_type = self.getLLVMType(param.type())
                param_name = param.ID().getText()
                param_list.append((param_name, param_type))

        # Create the LLVM function type and function.
        func_type = ir.FunctionType(ret_type, [ptype for _, ptype in param_list])
        function = ir.Function(self.module, func_type, name=func_name)

        # Create an entry block and set the builder.
        block = function.append_basic_block(name="entry")
        self.builder = ir.IRBuilder(block)

        # Populate function's symbol table with parameters.
        self.func_symtab = {}
        for i, (param_name, param_type) in enumerate(param_list):
            arg = function.args[i]
            arg.name = param_name
            ptr = self.builder.alloca(param_type, name=param_name)
            self.builder.store(arg, ptr)
            self.func_symtab[param_name] = ptr

        # Visit the compound statement (function body).
        self.visit(ctx.compoundStatement())

        # Ensure the function ends with a return instruction.
        if self.builder.block.terminator is None:
            if isinstance(ret_type, ir.VoidType):
                self.builder.ret_void()
            else:
                self.builder.ret(ir.Constant(ret_type, 0))
        return function

    def visitCompoundStatement(self, ctx: CmashParser.CompoundStatementContext):
        # Process each declaration or statement in the compound statement.
        for child in ctx.getChildren():
            self.visit(child)

    def visitExpression(self, ctx: CmashParser.ExpressionContext):
        """
        Extended visitor for expressions that handles short-circuit boolean evaluation
        for '&&' and '||' as well as unary '!' and a few basic terminals.
        """
        child_count = ctx.getChildCount()

        # Handle binary boolean operators with short-circuit evaluation.
        if child_count == 3:
            left = self.visit(ctx.getChild(0))
            op = ctx.getChild(1).getText()
            # We need to treat boolean operations as i1 type.
            bool_type = ir.IntType(1)
            current_function = self.builder.function

            if op == "&&":
                # Create blocks for the true branch and merge.
                left_block = self.builder.block
                then_block = current_function.append_basic_block("and.then")
                merge_block = current_function.append_basic_block("and.merge")
                # If left is true, jump to then_block; otherwise, jump to merge_block.
                self.builder.cbranch(left, then_block, merge_block)
                
                # Then block: evaluate the right-hand side.
                self.builder.position_at_start(then_block)
                right_val = self.visit(ctx.getChild(2))
                self.builder.branch(merge_block)
                then_block = self.builder.block  # update then_block after branch
                
                # Merge block: combine the two paths.
                self.builder.position_at_start(merge_block)
                phi = self.builder.phi(bool_type)
                # If left was false, we come directly from left_block and result is false.
                phi.add_incoming(ir.Constant(bool_type, 0), left_block)
                # If left was true, we come from then_block and the result is right_val.
                phi.add_incoming(right_val, then_block)
                return phi

            elif op == "||":
                # Create blocks for the false branch and merge.
                left_block = self.builder.block
                else_block = current_function.append_basic_block("or.else")
                merge_block = current_function.append_basic_block("or.merge")
                # If left is true, jump directly to merge_block; otherwise, evaluate right.
                self.builder.cbranch(left, merge_block, else_block)
                
                # Else block: evaluate the right-hand side.
                self.builder.position_at_start(else_block)
                right_val = self.visit(ctx.getChild(2))
                self.builder.branch(merge_block)
                else_block = self.builder.block  # update else_block after branch

                # Merge block: combine the two paths.
                self.builder.position_at_start(merge_block)
                phi = self.builder.phi(bool_type)
                # If left was true, we come from left_block and the result is true.
                phi.add_incoming(ir.Constant(bool_type, 1), left_block)
                # If left was false, we come from else_block and the result is right_val.
                phi.add_incoming(right_val, else_block)
                return phi

            # For other binary operators such as XOR, you might not require short-circuit.
            elif op == "^":
                right = self.visit(ctx.getChild(2))
                return self.builder.xor(left, right)

        # Handle unary operator '!' for boolean NOT.
        elif child_count == 2:
            op = ctx.getChild(0).getText()
            if op == "!":
                operand = self.visit(ctx.getChild(1))
                bool_type = ir.IntType(1)
                # Logical NOT is implemented as XOR with 1.
                return self.builder.xor(operand, ir.Constant(bool_type, 1))

        # Terminal cases: integer literal.
        if ctx.INT():
            # For simplicity, assume non-zero integer is true.
            int_val = int(ctx.INT().getText())
            return ir.Constant(ir.IntType(1), 1 if int_val != 0 else 0)

        # You can extend handling for FLOAT, DOUBLE, identifiers, etc.
        # Fallback: return None (or add more cases as needed).
        return None

    # Utility function to convert a parsed type to an LLVM type.
    def getLLVMType(self, typeCtx):
        text = typeCtx.getText()
        if text == "int":
            return ir.IntType(32)
        elif text == "float":
            return ir.FloatType()
        elif text == "double":
            return ir.DoubleType()
        elif text == "void":
            return ir.VoidType()
        elif text == "char":
            return ir.IntType(8)
        elif text == "bool":
            return ir.IntType(1)
        # For struct types or unknown types, add appropriate handling.
        else:
            # Default to 32-bit integer for simplicity.
            return ir.IntType(32)

def main(argv):
    # Read the source file provided as a command line argument.
    input_stream = FileStream(argv[1])
    
    # Set up the lexer with a custom error listener.
    lexer = CmashLexer(input_stream)
    lexer.removeErrorListeners()  # Remove default console error listener.
    lexer_error_listener = MyErrorListener()
    lexer.addErrorListener(lexer_error_listener)
    
    stream = CommonTokenStream(lexer)
    
    # Set up the parser with a custom error listener.
    parser = CmashParser(stream)
    parser.removeErrorListeners()  # Remove default console error listener.
    parser_error_listener = MyErrorListener()
    parser.addErrorListener(parser_error_listener)
    
    # Parse the input.
    tree = parser.program()

    # If any lexical or syntax errors occurred, output them and exit.
    errors = lexer_error_listener.errors + parser_error_listener.errors
    if errors:
        print("Errors during lexical/syntactic analysis:")
        for err in errors:
            print(err)
        sys.exit(1)
    
    # Generate LLVM IR by visiting the parse tree.
    codegen = CodeGenerator()
    module = codegen.visit(tree)
    
    # Print the generated LLVM IR.
    print(module)

if __name__ == '__main__':
    main(sys.argv)
