import java.io.FileNotFoundException;

public class ASTSemCol implements ASTNode {

    ASTNode lhs, rhs;

    public ASTSemCol(ASTNode l, ASTNode r) {
        lhs = l;
        rhs = r;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        IValue v1 = lhs.eval(e);
        IValue v2 = rhs.eval(e);

        return v2;
    }

    @Override
    public void compile(CodeBlock c, Environment<IValue> e) throws FileNotFoundException {
        lhs.compile(c, e);
        // c.emit("pop");
        rhs.compile(c, e);
    }
}
