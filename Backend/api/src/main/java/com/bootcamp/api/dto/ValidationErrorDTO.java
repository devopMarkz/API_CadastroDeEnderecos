package com.bootcamp.api.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationErrorDTO extends ErrorResponseDTO{

    private List<ErrorFields> errors = new ArrayList<>();

    public ValidationErrorDTO(Instant timestamp, Integer status, String path, String message) {
        super(timestamp, status, path, message);
    }

    public List<ErrorFields> getErrors() {
        return errors;
    }

    public void addErrors(ErrorFields error){
        errors.add(error);
    }
}
