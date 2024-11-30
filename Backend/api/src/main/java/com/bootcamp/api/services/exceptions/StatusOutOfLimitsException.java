package com.bootcamp.api.services.exceptions;

public class StatusOutOfLimitsException extends RuntimeException {
    public StatusOutOfLimitsException(String message) {
        super(message);
    }
}
