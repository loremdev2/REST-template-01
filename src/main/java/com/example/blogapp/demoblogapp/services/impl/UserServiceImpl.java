package com.example.blogapp.demoblogapp.services.impl;

import com.example.blogapp.demoblogapp.entities.User;
import com.example.blogapp.demoblogapp.exceptions.DuplicateUserException;
import com.example.blogapp.demoblogapp.exceptions.ResourceNotFoundException;
import com.example.blogapp.demoblogapp.payloads.UserDTO;
import com.example.blogapp.demoblogapp.repositories.UserRepo;
import com.example.blogapp.demoblogapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDTO createUser(UserDTO userDto) {
        User existingUser=userRepo.findByEmail(userDto.getEmail());
        if(existingUser!=null){
            throw new DuplicateUserException("User with email"+ userDto.getEmail()+" already exists");
        }
        User user= this.dtoTouser(userDto);
        User savedUser= userRepo.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDTO updateUser(UserDTO userDto, Integer userId) {
        User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "userId", userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        user.setPassword(userDto.getPassword());
        User updatedUser= this.userRepo.save(user);
        return this.userToDto(updatedUser);
    }

    @Override
    public UserDTO getUserById(Integer userId) {
        User user= this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "userId", userId));
        return this.userToDto(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users= this.userRepo.findAll();
        return users.stream().map(this::userToDto).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Integer userId) {
        User user= this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "userId", userId));
        this.userRepo.delete(user);
    }


    private User dtoTouser(UserDTO userDto){
        User user= new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        user.setPassword(userDto.getPassword());
        return user;
    }

    public UserDTO userToDto(User user){
        UserDTO userDTO= new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setAbout(user.getAbout());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }
}
