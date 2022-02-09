package com.shane.mathack.util.expression;

import java.util.Random;


// This package of classes implements this grammar:
//
// E -> I
// E -> E + E
// E -> M * M
// M -> I
// M -> (E + E)
// M -> M * M


public class Expression {

    public Expression(int depth, int border) {
        final Expression out;
        if (depth <= 0) {
            out = new IntExpression(border);
        } else {
            Random rand = new Random();
            if (0 == rand.nextInt(2)) {
                out = new AddExpression(depth - 1, border);
            } else {
                out = new MultiplyExpression(depth - 1, border);
            }
        }

        this.mValue = out.evaluate();
        this.mStr = out.toString();
    }

    public Expression() {}

    public String toString() {
        return this.mStr;
    }

    public int evaluate() {
        return this.mValue;
    }

    protected int mValue;
    protected String mStr;
}
