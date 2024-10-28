package src.main.java.com.monke.ast;

import src.main.java.com.monke.Environment;
import src.main.java.com.monke.values.IValue;
import src.main.java.com.monke.values.VBool;

public class ASTBoolean implements ASTNode {

    boolean val;

    public ASTBoolean(boolean val) {
        this.val = val;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        return new VBool(val);
    }
}
