package src.main.java.com.monke.ast;

import src.main.java.com.monke.Environment;
import src.main.java.com.monke.exceptions.TypeErrorException;
import src.main.java.com.monke.values.IValue;
import src.main.java.com.monke.values.VBool;

import java.io.FileNotFoundException;

public class ASTNot implements ASTNode {

    ASTNode node;

    public ASTNot(ASTNode n) {
        node = n;
    }

    public IValue eval(Environment<IValue> e) {
        IValue v = node.eval(e);

        if (v instanceof VBool) {
            IValue value = new VBool(!((VBool) v).getValue());
            return value;
        }

        throw new TypeErrorException("Not");
    }

}
