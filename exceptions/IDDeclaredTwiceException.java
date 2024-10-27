public class IDDeclaredTwiceException extends RuntimeException{

    public IDDeclaredTwiceException(){
        super("ID declared twice for this scope");
    }

}
