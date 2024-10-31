package com.dummylang.ast;

import com.dummylang.Environment;
import com.dummylang.exceptions.TypeErrorException;
import com.dummylang.values.IValue;
import com.dummylang.values.VBool;

public class ASTNot implements ASTNode {

    ASTNode node;

    public ASTNot(ASTNode n) {
        node = n;
    }

    public IValue eval(Environment<IValue> e) {
        IValue v = node.eval(e);

        if (v instanceof VBool) {
            return new VBool(!((VBool) v).getValue());
        }

        throw new TypeErrorException("Not");
    }

}
