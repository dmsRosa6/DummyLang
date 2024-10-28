package src.main.java.com.monke.ast;

import src.main.java.com.monke.Environment;
import src.main.java.com.monke.exceptions.TypeErrorException;
import src.main.java.com.monke.values.IValue;
import src.main.java.com.monke.values.VInt;

public class ASTIncrement implements ASTNode{
    ASTNode value;

    public ASTIncrement(ASTNode value) {
        this.value = value;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        IValue v = value.eval(e);
        if (v instanceof VInt){
            return new VInt(((VInt) v).getValue() + 1);
        }

        throw new TypeErrorException("Value is not a int");
    }
}
