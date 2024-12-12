package com.dummylang.ast;

import com.dummylang.Environment;
import com.dummylang.exceptions.ReturnException;
import com.dummylang.values.IValue;

public class ASTSemCol implements ASTNode {
    private final ASTNode first;
    private final ASTNode second;

    public ASTSemCol(ASTNode first, ASTNode second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        try {
            first.eval(e);
            return second.eval(e);
        } catch (ReturnException returnException) {
            // If first statement is a return, immediately propagate the return
            throw returnException;
        }
    }
}