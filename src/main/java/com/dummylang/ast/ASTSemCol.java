package com.dummylang.ast;

import com.dummylang.Environment;
import com.dummylang.values.IValue;

public class ASTSemCol implements ASTNode {

    ASTNode lhs, rhs;

    public ASTSemCol(ASTNode l, ASTNode r) {
        lhs = l;
        rhs = r;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        IValue v1 = lhs.eval(e);
        IValue v2 = rhs.eval(e);

        return v2;
    }

}
