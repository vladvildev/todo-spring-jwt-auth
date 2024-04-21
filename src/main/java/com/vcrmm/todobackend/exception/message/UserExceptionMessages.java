package com.vcrmm.todobackend.exception.message;

public enum UserExceptionMessages {
    USER_NOT_FOUND_BY_ID("User was not found by id.");

    private final String message;

    UserExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
