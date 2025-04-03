// Define the name of the grammar.
grammar Cmash;

// ***** Parser Rules *****
// The starting rule of the grammar.
program
    : (structDefinition | declaration | functionDefinition)* EOF
    ;

// A variable declaration (e.g., int x;).
declaration
    : type? variableList END_OF_LINE?
    | stringDeclaration
    | type ID arraySize (arraySize)* ('=' '[' values ']')? END_OF_LINE?
    | type ID matrixSize ('=' '<' matrixRow (';' matrixRow)* '>')? END_OF_LINE?
    ;

// Helper for matrixes and arrays declaration
values
    : value (',' value)*
    ;

// Either variable name or value
value
    : ID
    | numbers
    | CHAR_LITERAL
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
    : numbers (',' numbers)*
    ;

// A string declaration with fixed length.
stringDeclaration
    : 'string' arraySize ID ( '=' PLAIN_TEXT )? END_OF_LINE?
    ;

variableList
    : variable (',' variable)*   // Multiple variables
    ;

variable
    : ID ('=' expression)?
    ;

// A function definition (e.g., int main() { ... }).
functionDefinition
    : type ID '(' parameters? ')' compoundStatement
    ;

// Structure Definitions
structDefinition
    : 'struct' ID compoundStruct END_OF_LINE?
    ;

// Compound structure: block of struct member declarations.
compoundStruct
    : '{' structMember* functionDefinition* '}'
    ;

// A struct member declaration.
structMember
    : type ID END_OF_LINE?
    ;

// Rule to define the type keywords (only a few types for simplicity).
type
    : 'int'
    | 'float'
    | 'void'
    | 'char'
    | 'double'
    | 'bool'
    | 'struct' ID
    | 'string' '[' INT ']' 
    ;

// Function parameters list (comma-separated).
parameters
    : parameter (',' parameter)*
    | ID (',' ID)*
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
    | loopStatement
    | ioStatement
    | jumpStatement
    ;

// An expression statement.
expressionStatement
    : expression END_OF_LINE?
    ;

// Expression rules.
expression
    : expression '&&' expression  // Logical AND 
    | expression '||' expression  // Logical OR 
    | expression '^' expression   // Logical XOR
    | '!' expression              // Logical NOT
    | CHAR_LITERAL
    | INT
    | FLOAT
    | DOUBLE
    | ID
    | BOOL_LITERAL
    | numbers '++'
    | numbers '--'
    | assignment
    | functionCall
    | fieldAccess
    | arrayAccess
    ;

// Assignment can either be an assignment or fall back to equality.
assignment
    : ID ASSIGNMENT_OPERATOR expression
    | fieldAccess ('=' | '*=' | '/=' | '%=' | '+=' | '-=' | '<<=' | '>>=' | '&=' | '^=' | '|=') expression
    | equality
    ;

// Equality expressions (using == or !=).
equality
    : relational (('==' | '!=') relational)*
    ;

// Relational expressions (using <, >, <=, >=).
relational
    : additive (('<' | '>' | '<=' | '>=') additive)*
    ;

// Additive expressions (handling + and -).
additive
    : multiplicative (('+' | '-') multiplicative)*
    ;

// Multiplicative expressions (handling *, /, and %).
multiplicative
    : primary (('*' | '/' | '%') primary)*
    ;

fieldAccess
    : primary '.' ID ('.' ID)* END_OF_LINE?
    ;

functionCall
    : ID '(' parameters? ')' END_OF_LINE?
    | fieldAccess '(' parameters? ')' END_OF_LINE?
    ;

// Primary expressions: an identifier, an integer literal, or a parenthesized expression.
primary
    : ID
    | INT
    | FLOAT
    | DOUBLE
    | CHAR_LITERAL
    | BOOL_LITERAL
    | '(' expression ')'
    ;

numbers
    : INT
    | FLOAT
    | DOUBLE
    ;

arrayAccess
    : ID '[' expression ']'* END_OF_LINE?
    ;

// An if-statement with optional else.
selectionStatement
    : IF '(' expression ')' statement (ELSE statement)?
    ;

// A while loop.
iterationStatement
    : WHILE '(' expression ')' statement
    ;

// A for loop
loopStatement
    : FOR '(' declaration? ';' assignment ';' expression ')' statement
    ;

// I/O Statements
ioStatement
    : 'print' '(' printArgs ')' END_OF_LINE?
    | 'read' '(' ID ')' END_OF_LINE?
    ;

// A return statement with an optional expression.
jumpStatement
    : RETURN expression? END_OF_LINE?
    ;

printArgs
    : printArg (',' printArg)*
    ;

// Each argument is either an expression or a string
printArg
    : expression
    | PLAIN_TEXT
    ;

// ***** Lexer Rules *****
// An identifier: starts with a letter or underscore, followed by letters, digits, or underscores.
ID  : [A-Z] [a-zA-Z0-9]* ;

// An integer literal.
INT : '-'?[0-9]+ ;
FLOAT   : '-'?[0-9]+ '.' [0-9]* [fF] ; // Float with 'f'
DOUBLE  : '-'?[0-9]+ '.' [0-9]* ([eE] [+-]? [0-9]+)? ; // Double
CHAR_LITERAL 
    : '\'' (ESCAPE_SEQUENCE | ~['\\]) '\''  // A single character or escape sequence
    ;
fragment ESCAPE_SEQUENCE
    : '\\' [btnr0'\\]  // Handles \b, \t, \n, \r, \0, \', \\
    ;

PLAIN_TEXT : '"' (~["\r\n])* '"';

BOOL_LITERAL
    : 'true'
    | 'false'
    ;

ASSIGNMENT_OPERATOR
    : '='
    | '*='
    | '/='
    | '%='
    | '+='
    | '-='
    | '<<='
    | '>>='
    | '&='
    | '^='
    | '|='
    ;

IF : [a-z] [a-z] ;
ELSE : [a-z] [a-z] [a-z] [a-z] ;
FOR : [a-z] [a-z] [a-z] ;
WHILE : [a-z] [a-z] [a-z] [a-z] [a-z] ;
RETURN : [a-z] [a-z] [a-z] [a-z][a-z] [a-z] ;

END_OF_LINE : '\r'? '\n' -> skip ;
// Whitespace (spaces, tabs, newlines) is skipped.
WS  : [ \t]+ -> skip ;