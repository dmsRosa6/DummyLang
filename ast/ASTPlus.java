import java.io.FileNotFoundException;

public class ASTPlus implements ASTNode {

    ASTNode lhs, rhs;

    public ASTPlus(ASTNode l, ASTNode r) {
        lhs = l;
        rhs = r;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        IValue v1 = lhs.eval(e);
        IValue v2 = rhs.eval(e);
        if (v1 instanceof VInt && v2 instanceof VInt) {
            IValue value = new VInt(((VInt) v1).getValue() + ((VInt) v2).getValue());
            return value;
        } else if (v1 instanceof VString && v2 instanceof VString) {
            IValue value = new VString(((VString) v1).getValue() + ((VString) v2).getValue());
            return value;
        }
        throw new TypeErrorException("Sum");
    }

    @Override
    public void compile(CodeBlock c, Environment<IValue> e) throws FileNotFoundException {
        lhs.compile(c, e);
        rhs.compile(c, e);
        c.emit("iadd");
    }

}
