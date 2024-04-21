package com.vcrmm.todobackend.exception.advice;

import com.vcrmm.todobackend.exception.ExceptionResponse;
import com.vcrmm.todobackend.exception.user.UserNotFoundByIdException;
import com.vcrmm.todobackend.exception.annotation.IncludeUserExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = IncludeUserExceptions.class)
public class UserExceptionsAdvice {
    @ExceptionHandler(UserNotFoundByIdException.class)
    public ResponseEntity<ExceptionResponse> handleUserNotFoundByIdException(String message) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(message);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exceptionResponse);
    }
}
