package src.main.java.com.monke.ast;

import src.main.java.com.monke.Environment;
import src.main.java.com.monke.values.IValue;
import src.main.java.com.monke.values.VString;

public class ASTString implements ASTNode {

    String value;

    public ASTString(String value) {
        this.value = value;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        return new VString(value);
    }

}
