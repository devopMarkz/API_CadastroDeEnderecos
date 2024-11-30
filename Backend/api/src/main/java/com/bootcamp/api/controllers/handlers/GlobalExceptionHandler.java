package com.bootcamp.api.controllers.handlers;

import com.bootcamp.api.dto.ErrorFields;
import com.bootcamp.api.dto.ErrorResponseDTO;
import com.bootcamp.api.dto.ValidationErrorDTO;
import com.bootcamp.api.services.exceptions.SiglaUfAndNomeUfExistsException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> methodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationErrorDTO validationErrorDTO = new ValidationErrorDTO(Instant.now(), status.value(), request.getRequestURI(), "Erro de processamento de dados.");
        e.getFieldErrors().forEach(fieldError -> validationErrorDTO.addErrors(new ErrorFields(fieldError.getField(), fieldError.getDefaultMessage())));
        return ResponseEntity.status(status).body(validationErrorDTO);
    }

    @ExceptionHandler(SiglaUfAndNomeUfExistsException.class)
    public ResponseEntity<ErrorResponseDTO> siglaUfAndNomeUfExists(SiglaUfAndNomeUfExistsException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.CONFLICT;
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(errorResponseDTO);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponseDTO> httpMessageNotReadable(HttpMessageNotReadableException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(Instant.now(), status.value(), "Erro de entrada de dados.", request.getRequestURI());
        return ResponseEntity.status(status).body(errorResponseDTO);
    }
}
