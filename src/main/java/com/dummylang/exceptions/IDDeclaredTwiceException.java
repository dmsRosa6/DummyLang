package com.dummylang.exceptions;

public class IDDeclaredTwiceException extends RuntimeException{

    public IDDeclaredTwiceException(){
        super("ID declared twice for this scope");
    }

}
