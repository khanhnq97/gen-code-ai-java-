package com.example.gen_code_ai.exception;

public class InvalidSeatIdException extends Throwable {
    public InvalidSeatIdException(String invalidSeatIds) {
        super(invalidSeatIds);
    }
}
