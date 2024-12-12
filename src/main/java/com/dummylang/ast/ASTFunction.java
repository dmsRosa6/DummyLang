package com.dummylang.ast;

import com.dummylang.Environment;
import com.dummylang.exceptions.BadNumberOfParamsException;
import com.dummylang.utils.VarType;
import com.dummylang.values.IValue;
import com.dummylang.values.VFun;

import java.util.Iterator;
import java.util.List;

public class ASTFunction implements ASTNode {
    String id;
    List<ASTNode> values;

    public ASTFunction(List<ASTNode> values, String id) {
        this.id = id;
        this.values = values;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        /*Environment<IValue> env = new Environment<>();
        VFun fun = ((VFun) e.find(id).getSecond());
        Iterator<String> paramsIterator = fun.getParams().iterator();
        Iterator<ASTNode> valuesIterator = values.iterator();

        env.assoc(fun.id, VarType.CONST, fun);

        while (paramsIterator.hasNext()) {
            if (!valuesIterator.hasNext())
                throw new BadNumberOfParamsException("Not enough parameters on function call");
            env.assoc(paramsIterator.next(), VarType.VAR, valuesIterator.next().eval(e));
        }
        if (valuesIterator.hasNext())
            throw new BadNumberOfParamsException("Too many parameters on function call");

        return fun.getBody().eval(env);*/
        return null;
    }

}
