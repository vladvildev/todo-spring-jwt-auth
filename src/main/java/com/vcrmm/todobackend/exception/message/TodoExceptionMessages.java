package com.vcrmm.todobackend.exception.message;

public enum TodoExceptionMessages {
    TODO_NOT_FOUND_BY_ID("Todo was not found by id.");

    private final String message;

    TodoExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
