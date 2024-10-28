package com.monke.ast;

import com.monke.Environment;
import com.monke.exceptions.TypeErrorException;
import com.monke.values.IValue;
import com.monke.values.VBool;
import com.monke.values.VInt;


public class ASTGreaterOrEqual implements ASTNode {

    ASTNode lhs, rhs;

    public ASTGreaterOrEqual(ASTNode l, ASTNode r) {
        lhs = l;
        rhs = r;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        IValue v1 = lhs.eval(e);
        IValue v2 = rhs.eval(e);
        if (v1 instanceof VInt && v2 instanceof VInt) {
            IValue value = new VBool(((VInt) v1).getValue() >= ((VInt) v2).getValue());
            return value;
        }

        throw new TypeErrorException("Greater or equal");
    }

}
