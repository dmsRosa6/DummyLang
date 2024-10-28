package src.main.java.com.monke.ast;


import src.main.java.com.monke.Environment;
import src.main.java.com.monke.ast.ASTNode;
import src.main.java.com.monke.exceptions.TypeErrorException;
import src.main.java.com.monke.values.IValue;
import src.main.java.com.monke.values.VCell;

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
}
