package src.main.java.com.monke.ast;

import src.main.java.com.monke.Environment;
import src.main.java.com.monke.values.IValue;

public class ASTId implements ASTNode {
    private String id;

    ASTId(String id) {
        this.id = id;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        return e.find(id);
    }

}
