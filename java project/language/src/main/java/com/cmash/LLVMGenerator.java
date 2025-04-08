package com.cmash;

import java.util.ArrayList;

class LLVMGenerator {
    private static StringBuilder globalBuilder = new StringBuilder();
    private static StringBuilder builder = new StringBuilder();

    private static int tempRegCount = 0;
    private static int labelCount = 0;
    private static int stringCount = 0;

    public static void reset() {
        builder.setLength(0); // Clear the StringBuilder
        tempRegCount = 0; // Reset temporary register count
        labelCount = 0; // Reset label count
        stringCount = 0; // Reset string count
    }

    public static void emit(String line) {
        builder.append(line).append("\n");
    }

    // Emits a line into the global buffer.
    public static void emitGlobal(String line) {
        globalBuilder.append(line).append("\n");
    }
    
    // Returns the final IR code with globals first, then functions.
    public static String getEmittedCode() {
        return globalBuilder.toString() + "\n" + builder.toString();
    }

    public static String newTempReg() {
        String name = "%t" + (tempRegCount++);
        return name;
    }

    // Generates a unique label for branching.
    public static String newLabel() {
        return "label" + (labelCount++);
    }

    public static void startFunction(String funcName, String llvmReturnType, String paramSig) {
        emit("define " + llvmReturnType + " @" + funcName + "(" + paramSig + ") {");
    }

    public static void endFunction() {
        emit("}");
        emit("");
    }

    public static void declareGlobal(String varName, String llvmType, String initVal) {
        emit("@" + varName + " = global " + llvmType + " " + initVal);
    }

    public static SelectionLabels newSelectionLabels(boolean hasElse) {
        String thenLabel = newLabel();
        String mergeLabel = newLabel();
        String elseLabel = hasElse ? newLabel() : null;
        return new SelectionLabels(thenLabel, elseLabel, mergeLabel);
    }
    
    public static void emitConditionalBranch(String condReg, SelectionLabels labels) {
        if (labels.elseLabel != null) {
            emit("br i1 " + condReg + ", label %" + labels.thenLabel + ", label %" + labels.elseLabel);
        } else {
            emit("br i1 " + condReg + ", label %" + labels.thenLabel + ", label %" + labels.mergeLabel);
        }
    }

    public static String newGlobalString(String text) {
        String name = "@.str" + (stringCount++);
        int length = text.length() + 1;
        // Emit the global constant in the global buffer.
        emitGlobal(name + " = constant [" + length + " x i8] c\"" + text + "\\00\"");
        return name;
    }

    public static String loadValue(String llvmType, String pointer) {
        String tmpReg = newTempReg();
        emit(tmpReg + " = load " + llvmType + ", " + llvmType + "* " + pointer);
        return tmpReg;
    }

    public static void FloatValueStore(String localPtr, ValueAndType initVal)
    {
        String doubleTemp = LLVMGenerator.newTempReg();
        String floatTemp = LLVMGenerator.newTempReg();

        // Save given constant under global variable
        LLVMGenerator.emit("store double " + initVal.register + " , double* @doubleToFloat\n");
        // Load given variable
        LLVMGenerator.emit(doubleTemp + "= load double, double* @doubleToFloat\n");
        // Perform truncating 
        LLVMGenerator.emit(floatTemp + "= fptrunc double " + doubleTemp + " to float");
        LLVMGenerator.emit("store float " + floatTemp+ ", float* " + localPtr + "\n");
    }

    public static String FloatToDouble(String localPtr)
    {
        String temp = LLVMGenerator.newTempReg();
        // Extend into double
        LLVMGenerator.emit(temp + "= fpext float " + localPtr + " to double \n");
        return temp;
    }

    public static String generate(){
        String text = "";
        text += "declare i32 @printf(i8*, ...)\n";
        text += "declare i32 @scanf(i8*, ...)\n";
        text += "@strp = constant [4 x i8] c\"%d\\0A\\00\"\n";
        text += "@strs = constant [4 x i8] c\"%s\\0A\\00\" \n";
        text += "@strpi = constant [4 x i8] c\"%d\\0A\\00\"\n";
        text += "@strpd = constant [4 x i8] c\"%f\\0A\\00\"\n";
        text += "@strd = constant [4 x i8] c\"%d\\0A\\00\"\n";
        text += "@strf = constant [4 x i8] c\"%f\\0A\\00\"\n";
        text += "@strlf = constant [5 x i8] c\"%lf\\0A\\00\", align 1\n";
        // Read operations
        text += "@strs_in = constant [3 x i8] c\"%d\\00\"\n";
        text += "@strd_in = constant [3 x i8] c\"%d\\00\" \n";   //For integers (i32)
        text += "@strf_in = constant [3 x i8] c\"%f\\00\" \n";  // For floats (float)
        text += "@strlf_in = constant [4 x i8] c\"%lf\\00\" \n";  //For doubles (double)
        text += "@doubleToFloat = global double 0.0\n";
        text += getEmittedCode();
        text += "define i32 @main() nounwind{\n";
        text += "%res = call i32 @Maine()\n";
        text += "ret i32 0 }\n";
        return text;
     }

}
