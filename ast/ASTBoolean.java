import java.io.FileNotFoundException;

public class ASTBoolean implements ASTNode {

    boolean val;

    public ASTBoolean(boolean val) {
        this.val = val;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        return new VBool(val);
    }

    @Override
    public void compile(CodeBlock c, Environment<IValue> e) throws FileNotFoundException {
        if (val)
            c.emit("iconst_1");
        else
            c.emit("iconst_0");
    }
}
