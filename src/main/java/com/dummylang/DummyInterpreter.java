package com.dummylang;

import com.dummylang.ast.ASTNode;
import com.dummylang.exceptions.ReturnException;
import com.dummylang.parser.Parser;
import com.dummylang.values.IValue;

public class DummyInterpreter {

    public static void main(String args[]) {
        Parser parser = new Parser(System.in);
        ASTNode exp;
        Environment<IValue> env;
        env = new Environment<>();
        while (true) {
            try {
                System.out.print("> ");
                exp = parser.Start();

                IValue v = exp.eval(env);
                if (v != null)
                    System.out.println("Eval: " + v);

            } catch (ReturnException re) {
                System.out.println("Return: " + re.getReturnValue());
            } catch (Exception e) {
                System.out.println("Syntax Error!");
                System.out.println(e.getMessage());
                parser.ReInit(System.in);
            }
        }
    }

    public static String interpret(String input) {
        try {
            Environment<IValue> environment = new Environment<>();
            Parser parser = new Parser(new java.io.StringReader(input));
            ASTNode exp = parser.Start();
            parser.ReInit(System.in);
            IValue result = exp.eval(environment);
            return result != null ? result.toString() : "No Output";
        } catch (ReturnException re) {
            return re.getReturnValue().toString();
        } catch (Exception e) {
            return "Syntax Error: " + e.getMessage();
        }
    }
}