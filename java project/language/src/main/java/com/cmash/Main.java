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
        
        // (Optional) Set up error listeners here
        
        // Parse starting from 'program'
        ParseTree tree = parser.program ();
        
        // Walk the parse tree using a custom listener or visitor

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new LLVMAction(), tree);
    }
}