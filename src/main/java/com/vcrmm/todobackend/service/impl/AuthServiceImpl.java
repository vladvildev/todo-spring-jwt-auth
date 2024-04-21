package com.vcrmm.todobackend.service.impl;

import com.vcrmm.todobackend.entity.User;
import com.vcrmm.todobackend.security.AuthResponse;
import com.vcrmm.todobackend.service.AuthService;
import com.vcrmm.todobackend.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final JwtServiceImpl jwtService;
    private final UserService userService;

    public AuthServiceImpl(JwtServiceImpl jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @Override
    public AuthResponse registerUser(User user) {
        String token = jwtService.generateToken(user);

        return AuthResponse
                .builder()
                .token(token)
                .build();
    }
}
