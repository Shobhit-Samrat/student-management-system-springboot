package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.LoginRequest;
import com.example.studentmanagement.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        if ("admin".equals(request.getUsername())
                && "admin123".equals(request.getPassword())) {

            return JwtUtil.generateToken(request.getUsername());
        }

        return "Invalid Credentials";
    }
}