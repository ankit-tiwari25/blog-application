package com.example.blogapp.blogapplication.impl;

import com.example.blogapp.blogapplication.dto.CategoryDTO;
import com.example.blogapp.blogapplication.entities.Category;
import com.example.blogapp.blogapplication.exceptions.ResourceNotFoundException;
import com.example.blogapp.blogapplication.repositories.CategoryRepo;
import com.example.blogapp.blogapplication.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO, Category.class);
        Category addedCategory = categoryRepo.save(category);

        return modelMapper.map(addedCategory, CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer id) {

        Category categoryDB = categoryRepo.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException ("Category", "Category Id", id));


        Category userCategory = modelMapper.map(categoryDTO, Category.class);
        BeanUtils.copyProperties(userCategory, categoryDB, "id");

        Category updatedCategory = categoryRepo.save(categoryDB);

        CategoryDTO updatedCategoryDTO = modelMapper.map(updatedCategory, CategoryDTO.class);

        return updatedCategoryDTO;
    }

    @Override
    public void deleteCatefory(Integer id) {
        Category categoryDB = categoryRepo.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException ("Category", "Category Id", id));

        categoryRepo.deleteById(id);
    }

    @Override
    public CategoryDTO getCategory(Integer id) {
        Category categoryDB = categoryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "Category id", id));

        CategoryDTO categoryDTO = modelMapper.map(categoryDB,CategoryDTO.class);
        return categoryDTO;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categoryList = categoryRepo.findAll();
        return categoryList.stream().map(category -> {
            return modelMapper.map(category, CategoryDTO.class);
        }).collect(Collectors.toList());

    }
}
