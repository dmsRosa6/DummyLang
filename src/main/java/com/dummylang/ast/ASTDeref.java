package com.dummylang.ast;


import com.dummylang.Environment;
import com.dummylang.values.IValue;
import com.dummylang.values.VCell;

public class ASTDeref implements ASTNode {

    ASTNode node;

    public ASTDeref(ASTNode node) {
        this.node = node;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        IValue reference = node.eval(e);
        return ((VCell) reference).get();

    }
}
