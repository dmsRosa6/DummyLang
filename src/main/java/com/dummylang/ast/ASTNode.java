package com.dummylang.ast;

import com.dummylang.Environment;
import com.dummylang.values.IValue;

public interface ASTNode {

    IValue eval(Environment<IValue> e);

}
