package src.main.java.com.monke.exceptions;

public class UndeclaredIdentifierException extends RuntimeException{

    public UndeclaredIdentifierException(){
        super("Identifier undeclared");
    }
}
