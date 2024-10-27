import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class ASTAssign implements ASTNode {

    ASTNode lhs, rhs;

    public ASTAssign(ASTNode l, ASTNode r) {
        lhs = l;
        rhs = r;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        IValue v1 = lhs.eval(e);
        IValue v2 = rhs.eval(e);
        if (v1 instanceof VCell) {
            ((VCell) v1).set(v2);
            return v2;
        }

        throw new TypeErrorException("Assign");
    }

    @Override
    public void compile(CodeBlock c, Environment<IValue> e) throws FileNotFoundException {
        if (!e.hasRef())
            e.createCompilerRefClass();
        lhs.compile(c, e);
        c.emit("checkcast ref_I");
        rhs.compile(c, e);
        c.emit("putfield ref_I/v I");
    }
}
