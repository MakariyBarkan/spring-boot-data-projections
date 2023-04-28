package com.example.demo.controller.advice;

import java.time.Instant;

import com.example.demo.service.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(NotFoundException ex, WebRequest webRequest) {
        return new ResponseEntity<>(
                new ErrorResponse(Instant.now(), HttpStatus.NOT_FOUND.value(), ex.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @Data
    @AllArgsConstructor
    private static class ErrorResponse {

        Instant timestamp;

        Integer status;

        Object message;
    }
}
