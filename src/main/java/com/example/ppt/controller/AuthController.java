package com.example.ppt.controller;

import com.example.ppt.dto.ApiResponse;
import com.example.ppt.model.User;
import com.example.ppt.service.AuthService;
import com.example.ppt.service.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid User user){
        user.setRole("USER");
        authService.register(user);
        return ResponseEntity.status(201).body(new ApiResponse("New user added !",201));
    }

    @GetMapping("/me")
    public ResponseEntity getUser(@AuthenticationPrincipal User user){
        user.setPassword("");
        return ResponseEntity.status(200).body(user);
    }

    @PostMapping("/login")
    public ResponseEntity login(){
        return ResponseEntity.status(200).body(new ApiResponse("Welcome back !",200));
    }
}