package com.javasharks.microservicios.exception;

public class CampoNullException extends RuntimeException {
    private String message;
    public CampoNullException(String message) {
        super(message);
        this.message = message;
    }
    public CampoNullException() {
    }
}
