import java.util.List;

public class VFun implements IValue {
    ASTNode body;
    String id;
    List<String> params;

    public VFun(ASTNode body, List<String> params, String id) {
        this.params = params;
        this.body = body;
        this.id = id;
    }

    public ASTNode getBody() {
        return body;
    }

    public List<String> getParams() {
        return params;
    }

    @Override
    public String toString() {
        return id;
    }

}
