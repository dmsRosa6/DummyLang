package com.dummylang.ast;

import com.dummylang.Environment;
import com.dummylang.exceptions.TypeErrorException;
import com.dummylang.values.IValue;
import com.dummylang.values.VInt;

public class ASTIncrement implements ASTNode{
    ASTNode value;

    public ASTIncrement(ASTNode value) {
        this.value = value;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        IValue v = value.eval(e);
        if (v instanceof VInt){
            return new VInt(((VInt) v).getValue() + 1);
        }

        throw new TypeErrorException("Value is not a int");
    }
}
