// Define the name of the grammar.
grammar Cmash;

// ***** Parser Rules *****
// The starting rule of the grammar.
program
    : (declaration | functionDefinition)* EOF
    ;

//============================================================================
// Variables declaration, init and types
//============================================================================
// Rule to define the type keywords (only a few types for simplicity).
type
    : 'int'
    | 'float'
    | 'char'
    ;

// Regexes for numeric types (int, float etc)
numeric
    : INT
    ;

// A variable declaration (e.g., int x;).
declaration
    : type ID ('=' relational)? ENDOFLINE?
    | type ID arraySize (arraySize)* ('=' '[' values ']')? ENDOFLINE?
    | type ID matrixSize ('=' '<' matrixRow (';' matrixRow)* '>')? ENDOFLINE?
    ;

// Helper for matrixes and arrays declaration
values
    : value (',' value)*
    ;

// Either variable name or value
value
    : ID
    | numeric
    | CHAR
    ;

// Helper for declaring size of array
arraySize
    : '[' INT ']'  
    ;  

// Helper for declaring size of matrix
matrixSize
    : '<' INT (',' INT)* '>'
    ;

matrixRow
    : numeric (',' numeric)*
    ;


//    
//============================================================================
// Function rules
//============================================================================
// A function definition (e.g., int main() { ... }).
functionDefinition
    : type ID '(' parameters? ')' compoundStatement
    ;

// Function parameters list (comma-separated).
parameters
    : parameter (',' parameter)*
    ;

// A single function parameter (e.g., int x).
parameter
    : type ID
    ;

// A compound statement is a block of declarations and statements enclosed in braces.
compoundStatement
    : '{' (declaration | statement)* '}'
    ;

// Generic statement rule that can be extended to include various kinds of statements.
statement
    : expressionStatement
    | compoundStatement
    | selectionStatement
    | iterationStatement
    | jumpStatement
    ;

// An expression statement (an expression optionally followed by a semicolon).
expressionStatement
    : expression ENDOFLINE?
    ;

// Expression rules (here a simplified version starting with assignment).
expression
    : assignment
    ;

// Assignment can either be an assignment or fall back to equality.
assignment
    : ID '=' expression
    | equality
    ;

//============================================================================
// Relational operators
//============================================================================
// Equality expressions (using == or !=).
equality
    : relational (('==' | '!=') relational)*
    ;

// Relational expressions (using <, >, <=, >=).
relational
    : additive (('<' | '>' | '<=' | '>=') additive)*
    ;

//============================================================================
// Arithmetical operators
//============================================================================
// Additive expressions (handling + and -).
additive
    : multiplicative (('+' | '-') multiplicative)*
    ;

// Multiplicative expressions (handling *, /, and %).
multiplicative
    : primary (('*' | '/' | '%') primary)*
    ;

// Primary expressions: an identifier, an integer literal, or a parenthesized expression.
primary
    : ID
    | INT
    | '(' expression ')'
    ;


//============================================================================
// Basic functionality - conditionals, loops etc...
//============================================================================
// An if-statement with optional else.
selectionStatement
    : IF '(' expression ')' statement (ELSE statement)?
    ;

// A while loop.
iterationStatement
    : WHILE '(' expression ')' statement
    ;

// A return statement with an optional expression.
jumpStatement
    : RETURN expression? ENDOFLINE?
    ;


//============================================================================
// ***** Lexer Rules *****
//============================================================================
// An identifier: starts with a letter or underscore, followed by letters, digits, or underscores.
ID  : [A-Z] [a-zA-Z0-9]* ;

// An integer literal.
INT : [0-9]+ ;
// Char literal
CHAR : ['][A-Za-z0-9]['] ;

IF : [a-z] [a-z] ;

FOR : [a-z] [a-z] [a-z] ;

WHILE : [a-z] [a-z] [a-z] [a-z] [a-z] ;

RETURN : [a-z] [a-z] [a-z] [a-z][a-z] [a-z] ;

ELSE : [a-z] [a-z] [a-z] [a-z] ;

ENDOFLINE : '\r'? '\n' -> skip ;

// Whitespace (spaces, tabs, newlines) is skipped.
WS  : [ \t]+ -> skip ;
