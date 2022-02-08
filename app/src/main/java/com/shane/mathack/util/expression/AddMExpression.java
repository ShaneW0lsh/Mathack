package com.shane.mathack.util.expression;

public class AddMExpression extends Expression {

    public AddMExpression(int depth, int border) {
        final Expression left, right;
        left = new Expression(depth-1, border/2);
        right = new Expression(depth-1, border/2);

        this.mValue = left.evaluate() + right.evaluate();
        this.mStr = String.format("(%s + %s)", left.toString(), right.toString());
    }
}
