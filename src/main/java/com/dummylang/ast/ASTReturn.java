package com.dummylang.ast;

import com.dummylang.Environment;
import com.dummylang.exceptions.ReturnException;
import com.dummylang.values.IValue;

public class ASTReturn implements ASTNode {
    private ASTNode returnValue;

    public ASTReturn(ASTNode returnValue) {
        this.returnValue = returnValue;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        // Evaluate the return value in the current environment
        IValue returnedValue = returnValue.eval(e);

        // Throw a special exception that includes both the value and the current environment
        throw new ReturnException(returnedValue, e);
    }
}

