import java.io.FileNotFoundException;

public class ASTSub implements ASTNode {
    ASTNode lhs, rhs;

    @Override
    public IValue eval(Environment<IValue> e) {
        IValue v1 = lhs.eval(e);
        IValue v2 = rhs.eval(e);
        if (v1 instanceof VInt && v2 instanceof VInt) {
            IValue value = new VInt(((VInt) v1).getValue() - ((VInt) v2).getValue());
            return value;
        }

        throw new TypeErrorException("Subtraction");
    }

    @Override
    public void compile(CodeBlock c, Environment<IValue> e) throws FileNotFoundException {
        lhs.compile(c, e);
        rhs.compile(c, e);
        c.emit("isub");
    }

    public ASTSub(ASTNode l, ASTNode r) {
        lhs = l;
        rhs = r;
    }
}
