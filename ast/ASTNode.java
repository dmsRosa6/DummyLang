import java.io.FileNotFoundException;

public interface ASTNode {

    IValue eval(Environment<IValue> e);

    void compile(CodeBlock c, Environment<IValue> e) throws FileNotFoundException;// todo nao esta generico
}
