package com.example.blogapp.blogapplication.impl;

import com.example.blogapp.blogapplication.dto.UserDto;
import com.example.blogapp.blogapplication.entities.User;
import com.example.blogapp.blogapplication.exceptions.ResourceNotFoundException;
import com.example.blogapp.blogapplication.repositories.UserRepo;
import com.example.blogapp.blogapplication.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDTO) {

        User user = convertToEntity(userDTO);
        user = userRepo.save(user);
        return  convertToDTO(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) throws Exception {
        User dbUser = userRepo.findById(userId).orElseThrow(() -> {
            return new ResourceNotFoundException("User","id", userId);
        });

        User newUser = convertToEntity(userDto);
        BeanUtils.copyProperties(newUser, dbUser, "id");
        newUser = userRepo.save(dbUser);
        return convertToDTO(newUser);


    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
        return convertToDTO(user);

    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepo.findAll();
        List<UserDto> userDTOs = users.stream().map(user -> convertToDTO(user)).collect(Collectors.toList());
        return userDTOs;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
        userRepo.delete(user);
    }

//    private User convertToEntity(UserDto userDto){
//        User user = new User();
//        BeanUtils.copyProperties(userDto,user);
//        return user;
//    }

    //Convert to Entity using ModelMapper

    public User convertToEntity(UserDto userDto){
        User user = modelMapper.map(userDto, User.class);
        return user;
    }


//    private UserDto convertToDTO(User user){
//        UserDto userDTO = new UserDto();
//        BeanUtils.copyProperties(user, userDTO);
//        return userDTO;
//    }

    // Convert to Dto using modelMapper
    public  UserDto convertToDTO(User user){
        UserDto userDto  = modelMapper.map(user, UserDto.class);
        return userDto;
    }
}
