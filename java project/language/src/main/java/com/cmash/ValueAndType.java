package com.cmash;

public class ValueAndType {
    public String register;  // e.g., "%t1" or "5"
    public String llvmType;  // e.g., "i32", "float", "double"

    public ValueAndType(String register, String llvmType) {
        this.register = register;
        this.llvmType = llvmType;
    }
}

