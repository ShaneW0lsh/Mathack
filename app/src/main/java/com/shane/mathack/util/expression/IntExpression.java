package com.shane.mathack.util.expression;

import java.util.Random;

class IntExpression extends Expression {

    public IntExpression(int border) {
        Random rand = new Random();
        this.value = rand.nextInt(border) + 1;
        this.inString = Integer.toString(this.value);
    }
}