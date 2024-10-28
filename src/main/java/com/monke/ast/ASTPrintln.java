package com.monke.ast;

import com.monke.Environment;
import com.monke.values.IValue;

public class ASTPrintln implements ASTNode {

    ASTNode body;

    public ASTPrintln(ASTNode body) {
        this.body = body;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        IValue value = body.eval(e);
        System.out.println(value);
        return null;
    }

}
