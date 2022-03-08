package com.shane.mathack.util.expression;

import java.util.Random;

class IntExpression extends Expression {

    public IntExpression(int border) {
        Random rand = new Random();
        mValue = rand.nextInt(border) + 1;
        mStr = Integer.toString(mValue);
    }
}