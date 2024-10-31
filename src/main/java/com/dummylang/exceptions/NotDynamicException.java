package com.dummylang.exceptions;

public class NotDynamicException extends RuntimeException{

    public NotDynamicException(){
        super("Var is constant");
    }

}
