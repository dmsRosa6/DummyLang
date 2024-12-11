package com.dummylang.ast;

import com.dummylang.Environment;
import com.dummylang.values.IValue;
import com.dummylang.values.VCell;

public class ASTPointer implements ASTNode{

    ASTNode node;
    public ASTPointer(ASTNode node){
        this.node = node;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        return new VCell(node.eval(e));
    }
}
