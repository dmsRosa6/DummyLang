package com.dummylang.ast;

import com.dummylang.Environment;
import com.dummylang.values.IValue;

public class ASTId implements ASTNode {
    private final String id;

    public ASTId(String id) {
        this.id = id;
    }

    public String getId(){
        return id;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        return e.find(id).getSecond();
    }

}
