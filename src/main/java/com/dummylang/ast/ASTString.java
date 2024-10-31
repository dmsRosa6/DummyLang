package com.dummylang.ast;

import com.dummylang.Environment;
import com.dummylang.values.IValue;
import com.dummylang.values.VString;

public class ASTString implements ASTNode {

    String value;

    public ASTString(String value) {
        this.value = value;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        return new VString(value);
    }

}
