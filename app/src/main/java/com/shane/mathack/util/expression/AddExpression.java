package com.shane.mathack.util.expression;

class AddExpression extends Expression {

    public AddExpression(int depth, int constraint) {
        final Expression left, right;
        left = new Expression(depth-1, constraint/2);
        right = new Expression(depth-1, constraint/2);

        mValue = left.evaluate() + right.evaluate();
        mStr = String.format("%s + %s", left.toString(), right.toString());
    }
}

