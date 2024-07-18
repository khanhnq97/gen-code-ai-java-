package com.example.gen_code_ai.exception;

public class ShowtimeNotFoundException extends RuntimeException{
    public ShowtimeNotFoundException(String showtimeNotFound) {
        super(showtimeNotFound);
    }
}
