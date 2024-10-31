package com.dummylang;

import com.dummylang.exceptions.IDDeclaredTwiceException;
import com.dummylang.exceptions.NotDynamicException;
import com.dummylang.exceptions.NotFoundException;
import com.dummylang.exceptions.UndeclaredIdentifierException;
import com.dummylang.utils.Pair;
import com.dummylang.utils.VarType;

import java.util.HashMap;
import java.util.Map;

public class Environment<T> {
    private final Environment<T> previousEnv;
    private final Map<String, Pair<VarType, T>> variables;

    public Environment() {
        previousEnv = null;
        variables = new HashMap<>();
    }

    public Environment(Environment<T> e) {
        previousEnv = e;
        variables = new HashMap<>();
    }

    public void assoc(String id, VarType type, T val) throws IDDeclaredTwiceException {
        if (variables.containsKey(id))
            throw new IDDeclaredTwiceException();
        variables.put(id, new Pair<>(type,val));
    }

    public void update(String id, T val) throws IDDeclaredTwiceException {
        Pair<VarType, T> v = variables.get(id);

        if (v == null)
            throw new NotFoundException();

        if(v.getFirst().equals(VarType.CONST)){
            throw new NotDynamicException();
        }
        variables.put(id, new Pair<>(v.getFirst(),val));
    }

    public Pair<VarType, T> find(String id) throws UndeclaredIdentifierException {
        Pair<VarType, T> t = variables.get(id);
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
