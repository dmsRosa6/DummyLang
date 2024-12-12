package com.dummylang.ast;

import com.dummylang.Environment;
import com.dummylang.exceptions.ReturnException;
import com.dummylang.values.IValue;

public class ASTEnv implements ASTNode {
    ASTNode body;

    public ASTEnv(ASTNode body) {
        this.body = body;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        Environment<IValue> scopedEnv = e.beginScope();
        try {
            return body.eval(scopedEnv);
        } catch (ReturnException re) {
            // If the return happened in this environment, pop the scope and rethrow
            if (re.getCurrentEnvironment() == scopedEnv) {
                e.endScope();
            }
            return re.getReturnValue();
        }
    }
}