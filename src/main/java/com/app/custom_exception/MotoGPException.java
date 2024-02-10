package com.app.custom_exception;

public class MotoGPException extends RuntimeException{
    public MotoGPException(String message) {
        super(message);
    }
}
