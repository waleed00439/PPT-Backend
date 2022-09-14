package com.example.ppt.service;

import com.example.ppt.model.User;
import com.example.ppt.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;

    public void register(User user){
        String hashedPassword= new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashedPassword);
        authRepository.save(user);
    }
}