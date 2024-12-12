package com.dummylang.ast;

import com.dummylang.Environment;
import com.dummylang.utils.VarType;
import com.dummylang.values.IValue;
import com.dummylang.values.VFun;

public class ASTFunctionEnv implements ASTNode {

    VFun fun;
    String id;

    public ASTFunctionEnv(String id, VFun fun) {
        this.fun = fun;
        this.id = id;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        //e.assoc(id, VarType.CONST,fun);
        //return fun;
        return null;
    }

}
