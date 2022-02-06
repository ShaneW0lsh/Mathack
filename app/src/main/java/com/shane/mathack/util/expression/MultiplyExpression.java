package com.shane.mathack.util.expression;

class MultiplyExpression extends Expression {

    public MultiplyExpression(int depth, int border) {
        final Expression left, right;
        left = new mExpression(depth-1, (int)Math.sqrt(border));
        right = new mExpression(depth-1, (int)Math.sqrt(border));

        this.value = left.evaluate() * right.evaluate();
        this.inString = String.format("%s * %s", left.toString(), right.toString());
    }
}
