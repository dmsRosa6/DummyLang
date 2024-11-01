package com.dummylang;


import com.dummylang.ast.ASTNode;
import com.dummylang.parser.Parser;
import com.dummylang.values.IValue;

public class DummyInterpreter {

    public static void main(String args[]) {
        Parser parser = new Parser(System.in);
        ASTNode exp;
        Environment<IValue> env = new Environment<>();
        while (true) {
            try {
                System.out.print("> ");
                exp = parser.Start();

                IValue v = exp.eval(env);
                if (v != null)
                    System.out.println("Eval: " + v);

            } catch (Exception e) {
                System.out.println("Syntax Error!");
                System.out.println(e.getMessage());
                parser.ReInit(System.in);
            }
        }
    }
}
