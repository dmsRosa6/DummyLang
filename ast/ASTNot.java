import java.io.FileNotFoundException;

public class ASTNot implements ASTNode {

    ASTNode node;

    public ASTNot(ASTNode n) {
        node = n;
    }

    public IValue eval(Environment<IValue> e) {
        IValue v = node.eval(e);

        if (v instanceof VBool) {
            IValue value = new VBool(!((VBool) v).getValue());
            return value;
        }

        throw new TypeErrorException("Not");
    }

    // might need to look at this one more time
    @Override
    public void compile(CodeBlock c, Environment<IValue> e) throws FileNotFoundException {
        node.compile(c, e);
        c.emit("ifeq L1");
        c.emit("sipush 0");
        c.emit("goto L2");
        c.emit("L1:");
        c.emit("sipush 1");
        c.emit("L2:");
    }
}
