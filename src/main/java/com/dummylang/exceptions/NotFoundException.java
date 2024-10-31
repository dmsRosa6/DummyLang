package com.dummylang.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(){
        super("ID not found");
    }

}
