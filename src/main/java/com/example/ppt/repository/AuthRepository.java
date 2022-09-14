package com.example.ppt.repository;

import com.example.ppt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository  extends JpaRepository<User,Integer> {
    User findUserByUsername(String username);
}