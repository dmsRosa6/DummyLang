package com.dummylang.ast;

import com.dummylang.Environment;
import com.dummylang.values.IValue;
import com.dummylang.values.VNil;

public class ASTNil implements ASTNode{

    public ASTNil(){

    }

    @Override
    public IValue eval(Environment<IValue> e) {
        return new VNil();
    }

}
