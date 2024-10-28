package com.monke.ast;

import com.monke.Environment;
import com.monke.values.IValue;

public class ASTPrintln implements ASTNode {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    ASTNode body;

    public ASTPrintln(ASTNode body) {
        this.body = body;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        IValue value = body.eval(e);
        System.out.println(ANSI_RED + value + ANSI_RESET);
        return null;
    }

}
