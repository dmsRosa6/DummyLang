package com.monke.ast;

import com.monke.Environment;
import com.monke.values.IValue;
import com.monke.values.VCell;

public class ASTNew implements ASTNode {
    ASTNode node;

    public ASTNew(ASTNode node) {
        this.node = node;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        IValue v1 = node.eval(e);
        return new VCell(v1);
    }

}
