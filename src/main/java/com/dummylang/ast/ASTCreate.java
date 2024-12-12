package com.dummylang.ast;

import com.dummylang.Environment;
import com.dummylang.exceptions.TypeErrorException;
import com.dummylang.utils.VarType;
import com.dummylang.values.IValue;
import com.dummylang.values.VCell;
import com.dummylang.values.VNil;

public class ASTCreate implements ASTNode{

    VarType type;
    ASTNode lhs, rhs;
    boolean p;

    public ASTCreate(String type, boolean p, ASTNode l, ASTNode r) {
        this.lhs = l;
        this.rhs = r;
        this.type = VarType.getType(type);
        this.p = p;
    }

    @Override
    public IValue eval(Environment<IValue> e) {

        if(p && type.equals(VarType.CONST)){
            throw new TypeErrorException("Const cant be a pointer");
        }

        if(!(lhs instanceof ASTId)){
            throw new TypeErrorException("Not an ID");
        }

        IValue v;
        if(rhs == null)
            v =  new VNil();
        else
            v = rhs.eval(e);

        e.assoc(((ASTId) lhs).getId(), type,p,v);

        return v;
    }
}
