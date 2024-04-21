package com.vcrmm.todobackend.service.impl;

import com.vcrmm.todobackend.entity.User;
import com.vcrmm.todobackend.exception.user.UserNotFoundByIdException;
import com.vcrmm.todobackend.exception.message.UserExceptionMessages;
import com.vcrmm.todobackend.repo.UserRepository;
import com.vcrmm.todobackend.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) throws UserNotFoundByIdException {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundByIdException(UserExceptionMessages.USER_NOT_FOUND_BY_ID.getMessage()));
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) throws UserNotFoundByIdException {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundByIdException(UserExceptionMessages.USER_NOT_FOUND_BY_ID.getMessage());
        }

        userRepository.deleteById(id);
    }
}
