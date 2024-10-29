package com.monke;


import com.monke.ast.ASTNode;
import com.monke.parser.Parser;
import com.monke.values.IValue;

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
