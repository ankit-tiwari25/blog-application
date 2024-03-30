package com.example.blogapp.blogapplication.impl;

import com.example.blogapp.blogapplication.dto.UserDto;
import com.example.blogapp.blogapplication.entities.User;
import com.example.blogapp.blogapplication.repositories.UserRepo;
import com.example.blogapp.blogapplication.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto createUser(UserDto userDTO) {

        User user = convertToEntity(userDTO);
        user = userRepo.save(user);
        return  convertToDTO(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) throws Exception {
        User user1 = userRepo.findById(userId).orElseThrow(() -> {
            return new Exception("Nahi mila yr..");
        });

        User user = convertToEntity(userDto);
        BeanUtils.copyProperties(user, user1, "id");
        user = userRepo.save(user1);
        return convertToDTO(user);


    }

    @Override
    public UserDto getUserById(Integer userId) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return null;
    }

    private User convertToEntity(UserDto userDto){
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        return user;
    }

    private UserDto convertToDTO(User user){
        UserDto userDTO = new UserDto();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }
}
