package com.example.mathack;

public class Expression {
    private String operation;

    private String answer;
    private String fVal, sVal;

    public Expression(String fVal, String sVal, String operation, String answer) {
        this.fVal = fVal;
        this.sVal = sVal;
        this.operation = operation;
        this.answer = answer;
    }

    public Expression() {};

    public void create(String fVal, String sVal, String operation, String answer) {
        this.fVal = fVal;
        this.sVal = sVal;
        this.operation = operation;
        this.answer = answer;
    }


    public String getAnswer() {
        return this.answer;
    }

    public String toString() {
        //TODO: rewrite this in fstring way 
        // String ret = fVal + ' ' + operation + ' ' + sVal + " = " + answer;
        String ret = fVal + ' ' + operation + ' ' + sVal;
        return ret;
    }
}
