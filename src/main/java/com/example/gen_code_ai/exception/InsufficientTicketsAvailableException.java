package com.example.gen_code_ai.exception;

public class InsufficientTicketsAvailableException extends RuntimeException {
    public InsufficientTicketsAvailableException(String message) {
        super(message);
    }
}
