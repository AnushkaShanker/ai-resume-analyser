package com.resumeanalyser.service;

import java.util.Optional;

import com.resumeanalyser.entity.User;

public interface UserService {

    User registerUser(User user);

    Optional<User> findByEmail(String email);

    User getUserById(Long userId);
}

