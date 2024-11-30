package com.bootcamp.api.services.exceptions;

public class InvalidTypeException extends RuntimeException {
    public InvalidTypeException(String message) {
        super(message);
    }
}
