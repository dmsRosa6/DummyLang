package com.dummylang.ast;

import com.dummylang.Environment;
import com.dummylang.exceptions.TypeErrorException;
import com.dummylang.utils.VarType;
import com.dummylang.values.IValue;

public class ASTCreate implements ASTNode{

    VarType type;
    ASTNode lhs, rhs;

    public ASTCreate(String type, ASTNode l, ASTNode r) {
        this.lhs = l;
        this.rhs = r;
        this.type = VarType.getType(type);
    }

    @Override
    public IValue eval(Environment<IValue> e) {


        //IValue newCell = new VCell(v, this.type);
        //if(lhs instanceof ASTId){
        //    e.assoc(((ASTId) lhs).getId(), newCell);
        //    return newCell;
        //}

        if(!(lhs instanceof ASTId)){
            throw new TypeErrorException("Not an ID");
        }

        IValue v = rhs.eval(e);
        e.assoc(((ASTId) lhs).getId(), type,v);

        return v;
    }
}
