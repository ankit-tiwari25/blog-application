package com.example.blogapp.blogapplication.repositories;

import com.example.blogapp.blogapplication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

}
