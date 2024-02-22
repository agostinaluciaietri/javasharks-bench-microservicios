package com.javasharks.microservicios.exception;

public class ClientNotFoundException extends RuntimeException {
    private String message;
    public ClientNotFoundException(String message) {
        super(message);
        this.message = message;
    }
    public ClientNotFoundException() {
    }
}
