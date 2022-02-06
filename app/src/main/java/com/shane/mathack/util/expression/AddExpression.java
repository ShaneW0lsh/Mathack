package com.shane.mathack.util.expression;

class AddExpression extends Expression {

    public AddExpression(int depth, int border) {
        final Expression left, right;
        left = new Expression(depth-1, border/2);
        right = new Expression(depth-1, border/2);

        this.value = left.evaluate() + right.evaluate();
        this.inString = String.format("%s + %s", left.toString(), right.toString());
    }
}

