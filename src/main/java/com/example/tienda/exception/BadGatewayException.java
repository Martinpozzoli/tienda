package com.example.tienda.exception;

public class BadGatewayException extends RuntimeException{

    private static final String DESCRIPTION = "Bad Gateway Exception";

    public BadGatewayException(String detail){
        super(DESCRIPTION + ". " + detail);
    }
}
