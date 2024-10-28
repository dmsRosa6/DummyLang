package com.monke.ast;


import com.monke.Environment;
import com.monke.exceptions.TypeErrorException;
import com.monke.values.IValue;
import com.monke.values.VBool;

public class ASTWhile implements ASTNode {

    ASTNode condition, body;

    public ASTWhile(ASTNode condition, ASTNode body) {
        this.body = body;
        this.condition = condition;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        IValue value = condition.eval(e);
        if (value instanceof VBool) {
            while (((VBool) value).getValue()) {
                body.eval(e);
                value = condition.eval(e);
            }
            return value;
        }
        throw new TypeErrorException("Condition is not a boolean");
    }

}
