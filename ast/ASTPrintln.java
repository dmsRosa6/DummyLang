import java.io.FileNotFoundException;

public class ASTPrintln implements ASTNode {

    ASTNode body;

    public ASTPrintln(ASTNode body) {
        this.body = body;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        IValue value = body.eval(e);
        System.out.println(value);
        return value;
    }

    @Override
    public void compile(CodeBlock c, Environment<IValue> e) throws FileNotFoundException {
        String type = "I";
        try {
            IValue value = body.eval(e);
            if (value instanceof VString)
                type = "Ljava/lang/Object;";
            body.compile(c, e);
            c.emit("dup");
            c.emit("getstatic java/lang/System/out Ljava/io/PrintStream;\n");
            c.emit("swap");
            c.emit("invokestatic java/lang/String/valueOf(" + type + ")Ljava/lang/String;");
            c.emit("invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V");
        } catch (Exception exp) {
            body.compile(c, e);
            c.emit("dup");
            c.emit("getstatic java/lang/System/out Ljava/io/PrintStream;\n");
            c.emit("swap");
            c.emit("invokestatic java/lang/String/valueOf(" + type + ")Ljava/lang/String;");
            c.emit("invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V");
        }
    }
}
