package com.example.blogapp.blogapplication.services;

import com.example.blogapp.blogapplication.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    //Create
     CategoryDTO createCategory (CategoryDTO categoryDTO);

    //Update

     CategoryDTO updateCategory (CategoryDTO categoryDTO, Integer id);
    //Delete
    void   deleteCatefory( Integer id);

    //Get

    CategoryDTO getCategory(Integer id);
    //GetAll
    List<CategoryDTO> getAllCategories();
}
