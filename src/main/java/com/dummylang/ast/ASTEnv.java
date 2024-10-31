package com.dummylang.ast;

import com.dummylang.Environment;
import com.dummylang.values.IValue;

public class ASTEnv implements ASTNode{

    ASTNode body;

    public ASTEnv(ASTNode body) {
        this.body = body;
    }

    @Override
    public IValue eval(Environment<IValue> e){
        e = e.beginScope();
        IValue v = body.eval(e);
        e = e.endScope();
        return v;
    }
}
