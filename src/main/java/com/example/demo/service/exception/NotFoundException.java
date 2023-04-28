package com.example.demo.service.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Object id) {
        super(String.format("Resource with id [%s] not found", id));
    }
}
