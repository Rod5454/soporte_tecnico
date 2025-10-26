package com.example.soporte_tecnico.exception;

public class SolicitudNotFoundException extends RuntimeException {
    public SolicitudNotFoundException(String message) {
        super(message);
    }
}