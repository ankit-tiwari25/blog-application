package com.example.blogapp.blogapplication.services;

import com.example.blogapp.blogapplication.dto.UserDto;
import com.example.blogapp.blogapplication.entities.User;
import java.util.List;
public interface UserService {
    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto userDto, Integer userId) throws Exception;
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();

}
