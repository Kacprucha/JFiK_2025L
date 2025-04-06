package com.cmash;

public class VariableInfo {
    public String pointerName;  // e.g., "%x.addr" or "@gVar"
    public String llvmType;     // e.g., "i32", "float", "double"

    public VariableInfo(String pointerName, String llvmType) {
        this.pointerName = pointerName;
        this.llvmType = llvmType;
    }
}

