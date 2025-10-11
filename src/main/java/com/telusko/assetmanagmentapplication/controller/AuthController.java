package com.telusko.assetmanagmentapplication.controller;

import com.telusko.assetmanagmentapplication.assetObjects.Role;
import com.telusko.assetmanagmentapplication.assetObjects.User;
import com.telusko.assetmanagmentapplication.repository.UserRepository;
import com.telusko.assetmanagmentapplication.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String email = request.get("email");
        String password = request.get("password");
        String roleStr = request.get("role"); // Role should be USER or ADMIN

        // Check if user already exists
        Optional<User> existingUser = userRepository.findByUsername(username);
        if (existingUser.isPresent()) {
            return ResponseEntity.badRequest().body("Error: Username already taken!");
        }

        // Convert role string to Enum
        Role role;
        try {
            role = Role.valueOf(roleStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: Invalid role! Use USER or ADMIN.");
        }

        // Create new user and hash password
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(passwordEncoder.encode(password)); // Hashing password
        newUser.setRole(role);

        // Save to database
        userRepository.save(newUser);

        return ResponseEntity.ok(Map.of("message", "User registered successfully!"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");

        if (username == null || password == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Username and Password are required"));
        }

        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isPresent() && passwordEncoder.matches(password, userOpt.get().getPassword())) {
            String token = jwtService.generateToken(username); // Pass username instead of User object
            return ResponseEntity.ok(Map.of("token", token, "role", userOpt.get().getRole()));
        } else {
            return ResponseEntity.status(401).body(Map.of("error", "Invalid Credentials"));
        }
    }
}
