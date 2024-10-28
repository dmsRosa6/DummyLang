package src.main.java.com.monke.ast;

import src.main.java.com.monke.Environment;
import src.main.java.com.monke.values.IValue;
import src.main.java.com.monke.values.VCell;

import java.io.FileNotFoundException;

public class ASTDeref implements ASTNode {

    ASTNode node;

    public ASTDeref(ASTNode node) {
        this.node = node;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        IValue reference = node.eval(e);
        return ((VCell) reference).get();

    }
}
