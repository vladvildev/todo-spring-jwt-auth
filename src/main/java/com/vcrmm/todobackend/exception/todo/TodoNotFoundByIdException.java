package com.vcrmm.todobackend.exception.todo;

public class TodoNotFoundByIdException extends Exception {
    public TodoNotFoundByIdException(String message) {
        super(message);
    }

    public TodoNotFoundByIdException(String message, Throwable cause) {
        super(message, cause);
    }
}