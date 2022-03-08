package com.shane.mathack.util.expression;

class MultiplyExpression extends Expression {

    public MultiplyExpression(int depth, int border) {
        final Expression left, right;
        left = new MExpression(depth-1, (int)Math.sqrt(border));
        right = new MExpression(depth-1, (int)Math.sqrt(border));

        mValue = left.evaluate() * right.evaluate();
        mStr = String.format("%s * %s", left.toString(), right.toString());
    }
}
