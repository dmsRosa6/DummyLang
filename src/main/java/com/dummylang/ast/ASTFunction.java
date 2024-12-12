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
        // Create a new environment for function execution
        Environment<IValue> env = new Environment<>(e); // Consider using the parent environment

        // Retrieve the function from the environment
        VFun fun = (VFun) e.find(id).getSecond();

        // Check if the number of provided arguments matches the function's parameters
        if (values.size() != fun.getParams().size()) {
            throw new BadNumberOfParamsException("Incorrect number of parameters");
        }

        // Bind function parameters to their argument values
        List<String> params = fun.getParams();
        for (int i = 0; i < params.size(); i++) {
            env.assoc(params.get(i), VarType.VAR, false, values.get(i).eval(e));
        }

        // Execute the function body in the new environment
        return fun.getBody().eval(env);
    }

}
