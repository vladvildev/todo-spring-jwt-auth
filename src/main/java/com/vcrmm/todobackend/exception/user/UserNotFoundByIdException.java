package com.vcrmm.todobackend.exception.user;

public class UserNotFoundByIdException extends Exception {
    public UserNotFoundByIdException(String message) {
        super(message);
    }

    public UserNotFoundByIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
