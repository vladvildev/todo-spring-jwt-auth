package com.vcrmm.todobackend.controller;

import com.vcrmm.todobackend.entity.User;
import com.vcrmm.todobackend.exception.annotation.IncludeUserExceptions;
import com.vcrmm.todobackend.exception.user.UserNotFoundByIdException;
import com.vcrmm.todobackend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@IncludeUserExceptions
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) throws UserNotFoundByIdException {
        return ResponseEntity.ok(userService.getUserById(id));
    }
}
