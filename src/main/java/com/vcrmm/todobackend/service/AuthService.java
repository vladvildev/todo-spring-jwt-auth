package com.vcrmm.todobackend.service;

import com.vcrmm.todobackend.entity.User;
import com.vcrmm.todobackend.security.AuthResponse;

public interface AuthService {
    AuthResponse registerUser(User user);
}
