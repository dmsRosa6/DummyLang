package src.main.java.com.monke;

import src.main.java.com.monke.exceptions.IDDeclaredTwiceException;
import src.main.java.com.monke.exceptions.UndeclaredIdentifierException;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class Environment<T> {
    private Environment<T> previousEnv;
    private Map<String, T> variables;
    private boolean has_ref;

    public Environment() {
        previousEnv = null;
        variables = new HashMap<>();
        has_ref = false;
    }

    public Environment(Environment<T> e) {
        previousEnv = e;
        variables = new HashMap<>();
    }

    public void assoc(String id, T val) throws IDDeclaredTwiceException {
        if (variables.containsKey(id))
            throw new IDDeclaredTwiceException();
        variables.put(id, val);
    }

    public T find(String id) throws UndeclaredIdentifierException {
        if (this.variables.containsKey(id)) {
            return this.variables.get(id);
        }
        if (previousEnv == null)
            throw new UndeclaredIdentifierException();
        return previousEnv.find(id);
    }

    public Environment<T> beginScope() {
        return new Environment(this);
    }

    public Environment<T> endScope() {
        return previousEnv;
    }

    public boolean hasRef() {
        Environment<T> env = this;
        while (!has_ref && env.previousEnv != null) {
            env = env.previousEnv;
        }
        return has_ref;
    }
}
