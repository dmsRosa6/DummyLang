package com.monke.ast;

import com.monke.Environment;
import com.monke.exceptions.TypeErrorException;
import com.monke.values.IValue;
import com.monke.values.VBool;

import java.io.FileNotFoundException;

public class ASTNot implements ASTNode {

    ASTNode node;

    public ASTNot(ASTNode n) {
        node = n;
    }

    public IValue eval(Environment<IValue> e) {
        IValue v = node.eval(e);

        if (v instanceof VBool) {
            return new VBool(!((VBool) v).getValue());
        }

        throw new TypeErrorException("Not");
    }

}
