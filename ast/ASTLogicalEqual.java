import java.io.FileNotFoundException;

public class ASTLogicalEqual implements ASTNode {
    ASTNode lhs, rhs;

    public ASTLogicalEqual(ASTNode l, ASTNode r) {
        lhs = l;
        rhs = r;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        IValue v1 = lhs.eval(e);
        IValue v2 = rhs.eval(e);
        if (v1 instanceof VInt && v2 instanceof VInt) {
            IValue value = new VBool(((VInt) v1).getValue() == ((VInt) v2).getValue());
            return value;
        }
        if (v1 instanceof VString && v2 instanceof VString) {
            IValue value = new VBool(((VString) v1).getValue().equals(((VString) v2).getValue()));
            return value;
        }
        if (v1 instanceof VBool && v2 instanceof VBool) {
            IValue value = new VBool(((VBool) v1).getValue() == (((VBool) v2).getValue()));
            return value;
        }
        throw new TypeErrorException("Logical equal");
    }

    @Override
    public void compile(CodeBlock c, Environment<IValue> e) throws FileNotFoundException {
        lhs.compile(c, e);
        rhs.compile(c, e);
        c.emit("isub");
        c.emit("ifeq L1");
        c.emit("sipush 0");
        c.emit("goto L2");
        c.emit("L1:\nsipush 1");
        c.emit("L2:");
    }
}
