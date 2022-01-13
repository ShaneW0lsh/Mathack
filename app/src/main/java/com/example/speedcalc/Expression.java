package com.example.speedcalc;

public class Expression {
    private String operation;

    private String answer;
    private String fVal, sVal;

    public Expression(String fVal, String sVal, String operation) {
        this.fVal = fVal;
        this.sVal = sVal;
        this.operation = operation;
    }

    public String getAnswer() {
        return this.answer;
    }

    public String[] getValues() {
        String[] ret = {this.fVal, this.sVal};
        return ret;
    }
}
