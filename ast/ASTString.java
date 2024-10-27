import java.io.FileNotFoundException;

public class ASTString implements ASTNode {

    String value;

    public ASTString(String value) {
        this.value = value;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        return new VString(value);
    }

    @Override
    public void compile(CodeBlock c, Environment<IValue> e) throws FileNotFoundException {
        c.emit("ldc \"" + value + "\"");
    }
}
