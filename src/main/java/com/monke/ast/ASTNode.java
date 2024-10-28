package src.main.java.com.monke.ast;

import src.main.java.com.monke.Environment;
import src.main.java.com.monke.values.IValue;

public interface ASTNode {

    IValue eval(Environment<IValue> e);

}
