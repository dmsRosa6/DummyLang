package com.monke.ast;

import com.monke.Environment;
import com.monke.values.IValue;

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
