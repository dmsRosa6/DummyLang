package com.monke.ast;


import com.monke.Environment;
import com.monke.exceptions.TypeErrorException;
import com.monke.values.*;

public class ASTLogicalEqual implements ASTNode {
    ASTNode lhs, rhs;

    public ASTLogicalEqual(ASTNode l, ASTNode r) {
        lhs = l;
        rhs = r;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        IValue v1 = lhs.eval(e);
        IValue v2 = rhs.eval(e);
        if (v1 instanceof VInt && v2 instanceof VInt) {
            IValue value = new VBool(((VInt) v1).getValue() == ((VInt) v2).getValue());
            return value;
        }
        if (v1 instanceof VString && v2 instanceof VString) {
            IValue value = new VBool(((VString) v1).getValue().equals(((VString) v2).getValue()));
            return value;
        }
        if (v1 instanceof VBool && v2 instanceof VBool) {
            IValue value = new VBool(((VBool) v1).getValue() == (((VBool) v2).getValue()));
            return value;
        }

        if (v1 instanceof VFloat && v2 instanceof VFloat) {
            IValue value = new VBool(((VFloat) v1).getValue() == (((VFloat) v2).getValue()));
            return value;
        }
        throw new TypeErrorException("Logical equal");
    }

}
