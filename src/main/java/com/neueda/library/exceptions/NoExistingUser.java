package com.neueda.library.exceptions;

public class NoExistingUser extends RuntimeException {
    public NoExistingUser(String message) {
        super(message);
    }
}