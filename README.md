# JFiK_2025L

This project is part of the semester's coursework for Compiler Design (JFiK).

## Project Structure
- **src/** - Contains the source code for the project.
- **tests/** - Includes test cases and related resources.
- **README.md** - This file, describing the project, guidelines, and instructions.

## What is it all about

### About the language
Cmash resembles C in its overall structure, but it does not use a semicolon (;) to terminate statements.
Its keywords are always lowercase and have fixed lengths:
- if as a 2 letter word
- else as a 4 letter word 
- for as a 3 letter word
- while as a 5 letter word
- return as a 6 letter word

Additional differences:
- Structures can contain function definitions.
- A string data type is available.

### Toolchain
We use ANTLR 4 to define the language grammar and Java to implement the Cmash compiler.

#### ANTLR files
The main grammar is in Cmash.g4. ANTLR-generated Java sources are placed in the .antlr/ directory.

#### Java project layout
- LLVMAction extends the listener class and, through its enter* / exit* methods, generates code for each grammar rule.
- LLVMGenerator provides helper routines for emitting reused LLVM code fragments.
- Two listeners—SemanticAnalyzer and CustomErrorListener—perform lexical and syntactic checks before compilation.
- Several helper classes support LLVMAction.
- Main accepts a path to a .cmash file and outputs LLVM IR.
- A Makefile builds the entire project.

### Supported language features
- support for variable types: integers, doubles, floats, string, boolens,
- basic support for standard input-output,
- support for basic arithmetic operations,
- support for array variables,
- support for matrix variables,
- support for logical values,
- support for conditional instructions, loop,
- possibility to create functions,
- support for variable scope,
- support for structures