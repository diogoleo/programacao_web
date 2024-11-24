package com.demo.resources.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.demo.services.exceptions.ResourceNotFoundException;


@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e) {
        StandardError err = new StandardError(
        	LocalDateTime.now(),
            HttpStatus.NOT_FOUND.value(),
            "Resource not found",
            e.getMessage(),
            e.getClass().getName()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
