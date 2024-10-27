public class ASTNum implements ASTNode {

    int val;

    public ASTNum(int n) {
        val = n;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        return new VInt(val);
    }

    @Override
    public void compile(CodeBlock c, Environment<IValue> e) {
        c.emit("sipush " + val);
    }

}
