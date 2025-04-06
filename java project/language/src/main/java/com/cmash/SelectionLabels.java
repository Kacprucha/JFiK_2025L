package com.cmash;

public class SelectionLabels {
    public String thenLabel;
    public String elseLabel; // May be null if no else clause.
    public String mergeLabel;
    
    public SelectionLabels(String thenLabel, String elseLabel, String mergeLabel) {
        this.thenLabel = thenLabel;
        this.elseLabel = elseLabel;
        this.mergeLabel = mergeLabel;
    }
}
