package com.monke.ast;

import com.monke.Environment;
import com.monke.exceptions.TypeErrorException;
import com.monke.values.IValue;
import com.monke.values.VBool;
import com.monke.values.VFloat;
import com.monke.values.VInt;

public class ASTGreater implements ASTNode {

    ASTNode lhs, rhs;

    public ASTGreater(ASTNode l, ASTNode r) {
        lhs = l;
        rhs = r;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        IValue v1 = lhs.eval(e);
        IValue v2 = rhs.eval(e);
        if (v1 instanceof VInt && v2 instanceof VInt) {
            return new VBool(((VInt) v1).getValue() > ((VInt) v2).getValue());
        }

        if (v1 instanceof VFloat && v2 instanceof VFloat) {
            return new VBool(((VFloat) v1).getValue() > ((VFloat) v2).getValue());
        }

        if (v1 instanceof VFloat && v2 instanceof VInt) {
            return new VBool(((VFloat) v1).getValue() > ((VInt) v2).getValue());
        }

        if (v1 instanceof VInt && v2 instanceof VFloat) {
            return new VBool(((VInt) v1).getValue() > ((VFloat) v2).getValue());
        }

        throw new TypeErrorException("Greater ");
    }

}
