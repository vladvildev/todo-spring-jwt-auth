package com.vcrmm.todobackend.controller;

import com.vcrmm.todobackend.entity.User;
import com.vcrmm.todobackend.security.AuthResponse;
import com.vcrmm.todobackend.service.UserService;
import com.vcrmm.todobackend.service.impl.AuthServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final UserService userService;
    private final AuthServiceImpl authService;

    public AuthController(UserService userService, AuthServiceImpl authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody User user) {
        userService.saveUser(user);

        return ResponseEntity.ok(authService.registerUser(user));
    }
}
