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

    @Override
    public void compile(CodeBlock c, Environment<IValue> e) throws FileNotFoundException {

    }
}
