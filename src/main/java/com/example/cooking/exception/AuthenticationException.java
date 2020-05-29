package com.example.cooking.exception;

public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String message, Exception e) {
        super(message);
    }

    public AuthenticationException(String message) {
        super(message);
    }
}
