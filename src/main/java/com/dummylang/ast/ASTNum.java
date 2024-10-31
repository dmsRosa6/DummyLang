package com.dummylang.ast;


import com.dummylang.Environment;
import com.dummylang.values.IValue;
import com.dummylang.values.NumType;
import com.dummylang.values.VFloat;
import com.dummylang.values.VInt;

public class ASTNum implements ASTNode {

    String val;
    NumType type;

    public ASTNum(String type, String val) {
        this.val = val;
        this.type = NumType.getType(type);
    }

    @Override
    public IValue eval(Environment<IValue> e) {

        switch (this.type){
            case INT:
                return new VInt(Integer.parseInt(val));
            case FLOAT:
                return new VFloat(Float.parseFloat(val));
            default:
        }
        return null;
    }
}
