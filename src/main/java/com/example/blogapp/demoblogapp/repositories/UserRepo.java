package com.example.blogapp.demoblogapp.repositories;

import com.example.blogapp.demoblogapp.entities.User;
import com.example.blogapp.demoblogapp.payloads.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
