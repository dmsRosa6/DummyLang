import java.io.FileNotFoundException;

public class ASTWhile implements ASTNode {

    ASTNode condition, body;

    public ASTWhile(ASTNode condition, ASTNode body) {
        this.body = body;
        this.condition = condition;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        IValue value = condition.eval(e);
        if (value instanceof VBool) {
            while (((VBool) value).getValue()) {
                body.eval(e);
                value = condition.eval(e);
            }
            return value;
        }
        throw new TypeErrorException("Condition is not a boolean");
    }

    @Override
    public void compile(CodeBlock c, Environment<IValue> e) throws FileNotFoundException {
        int nextLabel1 = c.getNewLabel();
        int nextLabel2 = c.getNewLabel();

        c.emit("L" + nextLabel1 + ":");
        condition.compile(c, e);
        c.emit("ifeq L" + nextLabel2);
        body.compile(c, e);
        c.emit("goto L" + nextLabel1);
        c.emit("L" + nextLabel2 + ":");
    }
}
