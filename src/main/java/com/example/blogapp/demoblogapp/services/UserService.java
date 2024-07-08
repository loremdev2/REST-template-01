package com.example.blogapp.demoblogapp.services;

import com.example.blogapp.demoblogapp.payloads.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {

    UserDTO createUser(UserDTO user);
    UserDTO updateUser(UserDTO user, Integer userId);
    UserDTO getUserById(Integer userId);
    List<UserDTO> getAllUsers();
    void deleteUser(Integer userId);
}
