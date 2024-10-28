package src.main.java.com.monke.ast;

import src.main.java.com.monke.Environment;
import src.main.java.com.monke.values.IValue;
import src.main.java.com.monke.values.VInt;

public class ASTNum implements ASTNode {

    int val;

    public ASTNum(int n) {
        val = n;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        return new VInt(val);
    }


}
