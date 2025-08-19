package com.neueda.library.exceptions;

public class NoBorrowedBooks extends RuntimeException {
    public NoBorrowedBooks(String message) {
        super(message);
    }
}
