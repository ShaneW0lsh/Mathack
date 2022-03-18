package com.shane.mathack.util;

import java.io.Serializable;

public class OperatorWrapper implements Serializable {
    private final Operator[] mOperators;

    public OperatorWrapper(Operator[] operators) {
        mOperators = operators;
    }

    public Operator[] getOperators() {
        return mOperators;
    }
}
