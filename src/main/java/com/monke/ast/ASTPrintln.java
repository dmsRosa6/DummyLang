package src.main.java.com.monke.ast;

import src.main.java.com.monke.Environment;
import src.main.java.com.monke.values.IValue;

public class ASTPrintln implements ASTNode {

    ASTNode body;

    public ASTPrintln(ASTNode body) {
        this.body = body;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        IValue value = body.eval(e);
        System.out.println(value);
        return value;
    }

}
