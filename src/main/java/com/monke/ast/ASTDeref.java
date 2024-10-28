package com.monke.ast;


import com.monke.Environment;
import com.monke.values.IValue;
import com.monke.values.VCell;

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
