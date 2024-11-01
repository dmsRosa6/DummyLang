package com.dummylang.ast;


import com.dummylang.Environment;
import com.dummylang.exceptions.TypeErrorException;
import com.dummylang.values.IValue;
import com.dummylang.values.VFloat;
import com.dummylang.values.VInt;

public class ASTTimes implements ASTNode {
    ASTNode lhs, rhs;

    public ASTTimes(ASTNode l, ASTNode r) {
        lhs = l;
        rhs = r;
    }
    
    @Override
    public IValue eval(Environment<IValue> e) {
        IValue v1 = lhs.eval(e);
        IValue v2 = rhs.eval(e);
        if (v1 instanceof VInt && v2 instanceof VInt) {
            return new VInt(((VInt) v1).getValue() * ((VInt) v2).getValue());
        }

        if (v1 instanceof VFloat && v2 instanceof VFloat) {
            return new VFloat(((VFloat) v1).getValue() * ((VFloat) v2).getValue());
        }

        if (v1 instanceof VFloat && v2 instanceof VInt) {
            return new VFloat(((VFloat) v1).getValue() * ((VInt) v2).getValue());
        }

        if (v1 instanceof VInt && v2 instanceof VFloat) {
            return new VFloat(((VInt) v1).getValue() * ((VFloat) v2).getValue());
        }



        throw new TypeErrorException("Multiplication");
    }

}
