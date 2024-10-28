package src.main.java.com.monke.ast;

import src.main.java.com.monke.Environment;
import src.main.java.com.monke.exceptions.TypeErrorException;
import src.main.java.com.monke.values.IValue;
import src.main.java.com.monke.values.VInt;

import java.io.FileNotFoundException;

public class ASTNeg implements ASTNode {

    ASTNode node;

    public ASTNeg(ASTNode n) {
        node = n;
    }

    public IValue eval(Environment<IValue> e) {
        IValue v = node.eval(e);

        if (v instanceof VInt) {
            IValue value = new VInt(-((VInt) v).getValue());
            return value;
        }

        throw new TypeErrorException("Negative");
    }

}