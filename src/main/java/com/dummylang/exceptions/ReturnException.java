package com.dummylang.exceptions;

import com.dummylang.Environment;
import com.dummylang.values.IValue;

public class ReturnException extends RuntimeException {
    private final IValue returnValue;
    private final Environment<IValue> currentEnvironment;

    public ReturnException(IValue returnValue, Environment<IValue> currentEnvironment) {
        this.returnValue = returnValue;
        this.currentEnvironment = currentEnvironment;
    }

    public IValue getReturnValue() {
        return returnValue;
    }

    public Environment<IValue> getCurrentEnvironment() {
        return currentEnvironment;
    }
}