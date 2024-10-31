package com.dummylang.exceptions;

public class UndeclaredIdentifierException extends RuntimeException{

    public UndeclaredIdentifierException(){
        super("Identifier undeclared");
    }
}
