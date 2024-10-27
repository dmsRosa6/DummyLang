import java.io.FileNotFoundException;

public class ASTGreater implements ASTNode {

    ASTNode lhs, rhs;

    public ASTGreater(ASTNode l, ASTNode r) {
        lhs = l;
        rhs = r;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        IValue v1 = lhs.eval(e);
        IValue v2 = rhs.eval(e);
        if (v1 instanceof VInt && v2 instanceof VInt) {
            IValue value = new VBool(((VInt) v1).getValue() > ((VInt) v2).getValue());
            return value;
        }

        throw new TypeErrorException("Greater ");
    }

    @Override
    public void compile(CodeBlock c, Environment<IValue> e) throws FileNotFoundException {
        lhs.compile(c, e);
        rhs.compile(c, e);
        c.emit("isub");
        c.emit("ifgt L1");
        c.emit("sipush 0");
        c.emit("goto L2");
        c.emit("L1:\nsipush 1");
        c.emit("L2:");
    }
}
