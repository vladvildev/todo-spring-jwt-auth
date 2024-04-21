package com.vcrmm.todobackend.service;

import com.vcrmm.todobackend.entity.User;
import com.vcrmm.todobackend.exception.user.UserNotFoundByIdException;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id) throws UserNotFoundByIdException;
    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(Long id) throws UserNotFoundByIdException;
}
