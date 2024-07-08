package com.example.blogapp.demoblogapp.exceptions;

public class DuplicateUserException extends RuntimeException {
    public DuplicateUserException (String message){
        super(message);
    }
    public DuplicateUserException (String message, Throwable cause){
        super(message, cause);
    }
}
