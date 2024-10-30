package com.monke.ast;


import com.monke.Environment;
import com.monke.values.IValue;
import com.monke.values.NumType;
import com.monke.values.VFloat;
import com.monke.values.VInt;

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
