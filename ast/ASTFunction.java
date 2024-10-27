import java.io.FileNotFoundException;
import java.util.List;

public class ASTFunction implements ASTNode {
    String id;
    List<ASTNode> values;

    public ASTFunction(List<ASTNode> values, String id) {
        this.id = id;
        this.values = values;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        Environment env = new Environment();
        var fun = ((VFun) e.find(id));
        var paramsIterator = fun.getParams().iterator();
        var valuesIterator = values.iterator();

        env.assoc(fun.id, fun);

        while (paramsIterator.hasNext()) {
            if (!valuesIterator.hasNext())
                throw new BadNumberOfParamsException("Not enough parameters on function call");
            env.assoc(paramsIterator.next(), valuesIterator.next().eval(e));
        }
        if (valuesIterator.hasNext())
            throw new BadNumberOfParamsException("Too many parameters on function call");

        return fun.getBody().eval(env);
    }

    @Override
    public void compile(CodeBlock c, Environment<IValue> e) throws FileNotFoundException {

    }
}
