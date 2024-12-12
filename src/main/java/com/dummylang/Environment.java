package com.dummylang;

import com.dummylang.exceptions.IDDeclaredTwiceException;
import com.dummylang.exceptions.NotDynamicException;
import com.dummylang.exceptions.NotFoundException;
import com.dummylang.exceptions.UndeclaredIdentifierException;
import com.dummylang.utils.Tuple;
import com.dummylang.utils.VarType;
import com.dummylang.values.IValue;
import com.dummylang.values.VCell;

import java.util.HashMap;
import java.util.Map;

public class Environment<T> {
    private final Environment<T> previousEnv;
    private final Map<String, Tuple<VarType, IValue, Boolean>> variables;

    public Environment() {
        previousEnv = null;
        variables = new HashMap<>();
    }

    public Environment(Environment<T> e) {
        previousEnv = e;
        variables = new HashMap<>();
    }

    public void assoc(String id, VarType type, boolean isPointer, IValue val) throws IDDeclaredTwiceException {
        if (variables.containsKey(id))
            throw new IDDeclaredTwiceException();
        IValue v = val;
        if(isPointer){
            v = new VCell(val);
        }
        variables.put(id, new Tuple<>(type,v,isPointer));
    }

    public void update(String id, IValue val) throws IDDeclaredTwiceException {
        Tuple<VarType, IValue, Boolean> v = variables.get(id);

        if (v == null)
            throw new NotFoundException();

        if(v.getFirst().equals(VarType.CONST)){
            throw new NotDynamicException();
        }
        IValue value = val;
        if(v.getThird()){
            value = new VCell(val);
        }
        variables.put(id, new Tuple<>(v.getFirst(),value,v.getThird()));
    }

    public Tuple<VarType, IValue,Boolean> find(String id) throws UndeclaredIdentifierException {
        Tuple<VarType, IValue,Boolean> t = variables.get(id);
        if (t != null) {
            return t;
        }
        if (previousEnv == null)
            throw new UndeclaredIdentifierException();
        return previousEnv.find(id);
    }

    public Environment<T> beginScope() {
        return new Environment<>(this);
    }

    public Environment<T> endScope() {
        return previousEnv;
    }
}
