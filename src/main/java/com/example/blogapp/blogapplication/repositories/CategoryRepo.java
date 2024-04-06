package com.example.blogapp.blogapplication.repositories;

import com.example.blogapp.blogapplication.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
