package src.main.java.com.monke.ast;

import src.main.java.com.monke.Environment;
import src.main.java.com.monke.values.IValue;
import src.main.java.com.monke.values.VFun;

import java.io.FileNotFoundException;

public class ASTFunctionEnv implements ASTNode {

    VFun fun;
    String id;

    public ASTFunctionEnv(String id, VFun fun) {
        this.fun = fun;
        this.id = id;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        e.assoc(id, fun);
        return fun;
    }

}
