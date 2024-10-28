package src.main.java.com.monke;

import src.main.java.com.monke.ast.ASTNode;

public class ICLInterpreter {

    public static void main(String args[]) {
        javacc.Parser parser = new javacc.Parser(System.in);
        ASTNode exp;
        while (true) {
            try {
                System.out.print("> ");
                exp = parser.Start();
                System.out.println(exp.eval(new Environment()));
            } catch (Exception e) {
                System.out.println("Syntax Error!");
                System.out.println(e.getMessage());
                parser.ReInit(System.in);
            }
        }
    }
}
