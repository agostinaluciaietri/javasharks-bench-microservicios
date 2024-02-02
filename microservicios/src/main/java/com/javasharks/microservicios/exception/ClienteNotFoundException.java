package com.javasharks.microservicios.exception;

public class ClienteNotFoundException extends RuntimeException {
    private String message;
    public ClienteNotFoundException(String message) {
        super(message);
        this.message = message;
    }
    public ClienteNotFoundException() {
    }
}
