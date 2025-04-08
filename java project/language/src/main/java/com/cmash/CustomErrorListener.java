package com.cmash;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.IntervalSet;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CustomErrorListener extends BaseErrorListener {

    private static final Logger logger = Logger.getLogger(CustomErrorListener.class.getName());
    
    private final List<String> errorMessages = new ArrayList<>();

    public List<String> getErrors() {
        return errorMessages;
    }
    
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line,
                            int charPositionInLine,
                            String msg,
                            RecognitionException e) {
                                
        String offendingText = "";
        if (offendingSymbol instanceof Token) {
            offendingText = ((Token) offendingSymbol).getText();
        }
    
        String expectedTokensMsg = "";
        if (recognizer instanceof Parser) {
            Parser parser = (Parser) recognizer;
            // get expected tokens at the point of error
            IntervalSet expectedTokens = parser.getExpectedTokens();
            // Convert expected tokens to a readable string using the vocabulary
            expectedTokensMsg = expectedTokens.toString(parser.getVocabulary());
        }
    
        // Build a comprehensive error message
        String errorMsg = String.format("Error at line %d, column %d: Unexpected symbol '%s'. Expected one of: %s",
                                         line, charPositionInLine, offendingText, expectedTokensMsg);
        // Log and store the error message
        logger.severe(errorMsg);
        errorMessages.add(errorMsg);
    }
}
