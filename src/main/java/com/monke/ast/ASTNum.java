package com.monke.ast;


import com.monke.Environment;
import com.monke.values.IValue;
import com.monke.values.VInt;

public class ASTNum implements ASTNode {

    int val;

    public ASTNum(int n) {
        val = n;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        return new VInt(val);
    }


}
