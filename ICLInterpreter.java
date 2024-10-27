public class ICLInterpreter {

    public static void main(String args[]) {
        Parser parser = new Parser(System.in);
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
