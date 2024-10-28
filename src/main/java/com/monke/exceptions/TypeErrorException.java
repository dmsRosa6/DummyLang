package src.main.java.com.monke.exceptions;

public class TypeErrorException extends RuntimeException{

    public TypeErrorException(String type){
        super(String.format("Illegal arguments to %s operator",type));
    }
}
