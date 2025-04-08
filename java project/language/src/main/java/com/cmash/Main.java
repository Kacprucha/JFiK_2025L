package com.cmash;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {
    public static void main (String[] args) throws Exception 
    {
        // Read the input source code
        CharStream input = CharStreams.fromFileName (args[0]);
        
        // Create the lexer and parser
        CmashLexer lexer = new CmashLexer (input);
        CommonTokenStream tokens = new CommonTokenStream (lexer);
        CmashParser parser = new CmashParser (tokens);

        // Instantiate custom error listener
        CustomErrorListener errorListener = new CustomErrorListener();

        // Remove the default error listeners
        lexer.removeErrorListeners();
        parser.removeErrorListeners();
        
        // Attach custom error listener to both lexer and parser
        lexer.addErrorListener(errorListener);
        parser.addErrorListener(errorListener);
        
        
        // Parse starting from 'program'
        ParseTree tree = parser.program ();

        // Check if any errors were recorded; if yes, display them and halt further processing
        if (!errorListener.getErrors().isEmpty()) {
            System.exit(1);
        }
        
        // Walk the parse tree using a custom listener or visitor
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new LLVMAction(), tree);
    }
}