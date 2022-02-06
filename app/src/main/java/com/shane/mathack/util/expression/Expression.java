package com.shane.mathack.util.expression;

import java.util.Random;

public class Expression {

    public Expression() {}
    public Expression(int depth, int border) {
        final Expression out;

        if (depth <= 0) {
            out = new IntExpression(border);
        } else {
            Random rand = new Random();
            int p = rand.nextInt(2);
            if (p == 1) {
                out = new AddExpression(depth-1, border);
            } else {
                out = new MultiplyExpression(depth-1, border);
            }
        }

        this.value = out.evaluate();
        this.inString = out.toString();
    }

    public String toString() {
        return this.inString;
    }

    public int evaluate() {
        return this.value;
    }

    protected int value;
    protected String inString;
}
