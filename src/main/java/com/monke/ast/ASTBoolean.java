package com.monke.ast;

import com.monke.Environment;
import com.monke.values.IValue;
import com.monke.values.VBool;

public class ASTBoolean implements ASTNode {

    boolean val;

    public ASTBoolean(boolean val) {
        this.val = val;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        return new VBool(val);
    }
}
