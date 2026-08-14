package com.workshop.course.entities.resources.errors;

import com.workshop.course.services.middlewares.DataBaseException;
import com.workshop.course.services.middlewares.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandartError> handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request) {
        String error = "Resource not found: ";
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StandartError standartError = new StandartError(Instant.now(), httpStatus.value(), error, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(httpStatus).body(standartError);
    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandartError> database(DataBaseException ex, HttpServletRequest request) {
        String error = "Database error: ";
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        StandartError standartError = new StandartError(Instant.now(), httpStatus.value(), error, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(httpStatus).body(standartError);
    }


}
