package com.monke.ast;

import com.monke.Environment;
import com.monke.values.IValue;

public class ASTId implements ASTNode {
    private final String id;

    public ASTId(String id) {
        this.id = id;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        return e.find(id);
    }

}
