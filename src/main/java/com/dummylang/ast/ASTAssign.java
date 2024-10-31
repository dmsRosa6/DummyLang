package com.dummylang.ast;

import com.dummylang.Environment;
import com.dummylang.exceptions.TypeErrorException;
import com.dummylang.utils.Pair;
import com.dummylang.utils.VarType;
import com.dummylang.values.IValue;

public class ASTAssign implements ASTNode {

    ASTNode lhs, rhs;

    public ASTAssign(ASTNode l, ASTNode r) {
        lhs = l;
        rhs = r;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        IValue v2 = rhs.eval(e);

        if (! ( lhs instanceof ASTId)){
            throw new TypeErrorException("Left is not an id");
        }
        String id = ((ASTId) lhs).getId();

        e.update(id,v2);

        return v2;
    }
}
