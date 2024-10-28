package com.monke.ast;

import com.monke.Environment;
import com.monke.values.IValue;

public interface ASTNode {

    IValue eval(Environment<IValue> e);

}
