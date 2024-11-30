package com.bootcamp.api.services.exceptions;

public class SiglaUfAndNomeUfExistsException extends RuntimeException {
    public SiglaUfAndNomeUfExistsException(String message) {
        super(message);
    }
}
