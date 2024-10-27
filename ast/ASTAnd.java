import java.io.FileNotFoundException;

public class ASTAnd implements ASTNode {
    ASTNode lhs, rhs;

    public ASTAnd(ASTNode l, ASTNode r) {
        lhs = l;
        rhs = r;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        IValue v1 = lhs.eval(e);
        IValue v2 = rhs.eval(e);
        if (v1 instanceof VBool && v2 instanceof VBool) {
            IValue value = new VBool(((VBool) v2).getValue() && ((VBool) v1).getValue());
            return value;
        }

        throw new TypeErrorException("And");
    }

    @Override
    public void compile(CodeBlock c, Environment<IValue> e) throws FileNotFoundException {
        lhs.compile(c, e);
        rhs.compile(c, e);
        c.emit("iand");
    }
}
