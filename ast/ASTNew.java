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

    @Override
    public void compile(CodeBlock c, Environment<IValue> e) throws FileNotFoundException {
        if (!e.hasRef())
            e.createCompilerRefClass();
        c.emit("new ref_I");
        c.emit("dup");
        c.emit("invokespecial ref_I/<init>()V");
        c.emit("dup");
        node.compile(c, e);
        c.emit("putfield ref_I/v I");
    }
}
