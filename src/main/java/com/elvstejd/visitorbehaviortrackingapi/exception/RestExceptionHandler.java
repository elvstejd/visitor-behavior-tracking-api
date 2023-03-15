package com.elvstejd.visitorbehaviortrackingapi.exception;

import com.elvstejd.visitorbehaviortrackingapi.connectionpoint.ConnectionPointNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> errors = new ArrayList<>();

        for  (FieldError error : ex.getFieldErrors()) {
            errors.add(error.getDefaultMessage());
        }

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST.value(), errors);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConnectionPointNotFoundException.class)
    public ResponseEntity<ApiError> handleConnectionPointNotFoundException(ConnectionPointNotFoundException ex) {
        List<String> errors = new ArrayList<>();

        errors.add(ex.getMessage());

        return new ResponseEntity<ApiError>(new ApiError(HttpStatus.NOT_FOUND.value(), errors), HttpStatus.NOT_FOUND);
    }
}
