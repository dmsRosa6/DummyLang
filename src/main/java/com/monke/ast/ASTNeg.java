package com.monke.ast;

import com.monke.Environment;
import com.monke.exceptions.TypeErrorException;
import com.monke.values.IValue;
import com.monke.values.VFloat;
import com.monke.values.VInt;

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