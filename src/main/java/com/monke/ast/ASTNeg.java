package com.monke.ast;

import com.monke.Environment;
import com.monke.exceptions.TypeErrorException;
import com.monke.values.IValue;
import com.monke.values.VInt;

public class ASTNeg implements ASTNode {

    ASTNode node;

    public ASTNeg(ASTNode n) {
        node = n;
    }

    public IValue eval(Environment<IValue> e) {
        IValue v = node.eval(e);

        if (v instanceof VInt) {
            IValue value = new VInt(-((VInt) v).getValue());
            return value;
        }

        throw new TypeErrorException("Negative");
    }

}