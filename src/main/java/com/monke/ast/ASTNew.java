package src.main.java.com.monke.ast;

import src.main.java.com.monke.Environment;
import src.main.java.com.monke.values.IValue;
import src.main.java.com.monke.values.VCell;

import java.io.FileNotFoundException;

public class ASTNew implements ASTNode {
    ASTNode node;

    public ASTNew(ASTNode node) {
        this.node = node;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        IValue v1 = node.eval(e);
        return new VCell(v1);
    }

}
