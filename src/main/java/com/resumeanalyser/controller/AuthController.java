package com.resumeanalyser.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.resumeanalyser.dto.UserRequestDTO;
import com.resumeanalyser.dto.UserResponseDTO;
import com.resumeanalyser.entity.User;
import com.resumeanalyser.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody UserRequestDTO dto) {

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        User savedUser = userService.registerUser(user);

        UserResponseDTO response = new UserResponseDTO();
        response.setUserId(savedUser.getUserId());
        response.setName(savedUser.getName());
        response.setEmail(savedUser.getEmail());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestParam String email) {

        return userService.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
    }

