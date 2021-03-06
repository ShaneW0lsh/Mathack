package com.shane.mathack.util.expression;

import java.util.Random;

public class MExpression extends Expression {

    public MExpression(int depth, int border) {
        final Expression out;
        if (depth <= 0) {
            out = new IntExpression(border);
        } else {
            Random rand = new Random();
            if (0 == rand.nextInt(2)) {
                out = new MultiplyExpression(depth - 1, border);
            } else {
                out = new AddMExpression(depth - 1, border);
            }
        }

        mValue = out.evaluate();
        mStr = out.toString();
    }
}
