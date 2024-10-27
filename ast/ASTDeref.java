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

    @Override
    public void compile(CodeBlock c, Environment<IValue> e) throws FileNotFoundException {
        String type = "I";
        if (node instanceof ASTId)
            type = "ref_I";
        node.compile(c, e);
        c.emit("checkcast " + type);
        c.emit("getfield " + type + "/v I");
    }
}
