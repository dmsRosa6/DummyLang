package src.main.java.com.monke.ast;

import src.main.java.com.monke.Environment;
import src.main.java.com.monke.exceptions.TypeErrorException;
import src.main.java.com.monke.values.IValue;
import src.main.java.com.monke.values.VBool;

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
