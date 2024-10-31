package com.dummylang.ast;

import com.dummylang.Environment;
import com.dummylang.values.IValue;
import com.dummylang.values.VBool;

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
