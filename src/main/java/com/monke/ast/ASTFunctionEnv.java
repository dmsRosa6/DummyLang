package com.monke.ast;

import com.monke.Environment;
import com.monke.values.IValue;
import com.monke.values.VFun;

public class ASTFunctionEnv implements ASTNode {

    VFun fun;
    String id;

    public ASTFunctionEnv(String id, VFun fun) {
        this.fun = fun;
        this.id = id;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        e.assoc(id, fun);
        return fun;
    }

}
