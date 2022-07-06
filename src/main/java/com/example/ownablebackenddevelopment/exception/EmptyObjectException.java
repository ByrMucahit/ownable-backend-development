package com.example.ownablebackenddevelopment.exception;

public class EmptyObjectException extends RuntimeException{
    private static final long serialVersionUID = -3685428524336481495L;

    public EmptyObjectException(String message){
        super(message);
    }
}
