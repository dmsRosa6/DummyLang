package com.dummylang.ast;

import com.dummylang.Environment;
import com.dummylang.ast.ASTNode;
import com.dummylang.values.IValue;

public class ASTEmpty implements ASTNode {
    public ASTEmpty() {

    }

    @Override
    public IValue eval(Environment<IValue> e) {
        return null;
    }
}
