import java.io.FileNotFoundException;

public class ASTNeg implements ASTNode {

    ASTNode node;

    public ASTNeg(ASTNode n) {
        node = n;
    }

    public IValue eval(Environment<IValue> e) {
        IValue v = node.eval(e);

        if (v instanceof VInt) {
            IValue value = new VInt(-((VInt) v).getValue());
            return value;
        }

        throw new TypeErrorException("Negative");
    }

    public void compile(CodeBlock c, Environment<IValue> e) throws FileNotFoundException {
        node.compile(c, e);
        c.emit("ineg");
    }
}