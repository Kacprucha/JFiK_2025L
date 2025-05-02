package com.cmash;

public class LoopLabels {
    String initLabel;
    String condLabel;
    String bodyLabel;
    String updateLabel;
    String endLabel;

    LoopLabels(String init, String cond, String body, String update, String end) {
        this.initLabel   = init;
        this.condLabel   = cond;
        this.bodyLabel   = body;
        this.updateLabel = update;
        this.endLabel    = end;
    }
}
