package com.vcrmm.todobackend.exception.advice;

import com.vcrmm.todobackend.exception.ExceptionResponse;
import com.vcrmm.todobackend.exception.annotation.IncludeTodoExceptions;
import com.vcrmm.todobackend.exception.todo.TodoNotFoundByIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = IncludeTodoExceptions.class)
public class TodoExceptionsAdvice {
    @ExceptionHandler(TodoNotFoundByIdException.class)
    public ResponseEntity<ExceptionResponse> handleTodoNotFoundByIdException(String message) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(message);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exceptionResponse);
    }
}
