package com.monke.ast;

import com.monke.Environment;
import com.monke.values.IValue;
import com.monke.values.VString;

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
