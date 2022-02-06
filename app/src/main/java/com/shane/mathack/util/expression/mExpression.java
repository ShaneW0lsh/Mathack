package com.shane.mathack.util.expression;

import java.util.Random;

public class mExpression extends Expression {

    public mExpression(int depth, int border) {
        final Expression out;
        if (depth <= 0) {
            out = new IntExpression(border);
        } else {
            Random rand = new Random();
            int p = rand.nextInt(2);
            if (p == 1) {
                out = new MultiplyExpression(depth-1, border);
            } else {
                out = new AddMExpression(depth-1, border);
            }
        }
        this.value = out.evaluate();
        this.inString = out.toString();
    }
}
