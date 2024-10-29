package com.monke.ast;

import com.monke.Environment;
import com.monke.exceptions.IDDeclaredTwiceException;
import com.monke.exceptions.TypeErrorException;
import com.monke.values.CellType;
import com.monke.values.IValue;
import com.monke.values.VCell;

public class ASTCreate implements ASTNode{

    CellType type;
    ASTNode lhs, rhs;

    public ASTCreate(String type, ASTNode l, ASTNode r) {
        this.lhs = l;
        this.rhs = r;
        this.type = CellType.getType(type);
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        IValue v = rhs.eval(e);

        IValue newCell = new VCell(v, this.type);
        if(lhs instanceof ASTId){
            e.assoc(((ASTId) lhs).getId(), newCell);
            return newCell;
        }

        throw new TypeErrorException("Not an ID");
    }
}
