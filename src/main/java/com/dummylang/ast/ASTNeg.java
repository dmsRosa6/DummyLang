package com.dummylang.ast;

import com.dummylang.Environment;
import com.dummylang.exceptions.TypeErrorException;
import com.dummylang.values.IValue;
import com.dummylang.values.VFloat;
import com.dummylang.values.VInt;

public class ASTNeg implements ASTNode {

    ASTNode node;

    public ASTNeg(ASTNode n) {
        node = n;
    }

    public IValue eval(Environment<IValue> e) {
        IValue v = node.eval(e);

        if (v instanceof VInt) {
            return new VInt(-((VInt) v).getValue());
        }

        if (v instanceof VFloat) {
            return new VFloat(-((VFloat) v).getValue());
        }

        throw new TypeErrorException("Negative");
    }

}