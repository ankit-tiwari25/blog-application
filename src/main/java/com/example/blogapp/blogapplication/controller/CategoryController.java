package com.example.blogapp.blogapplication.controller;

import com.example.blogapp.blogapplication.dto.APIResponse;
import com.example.blogapp.blogapplication.dto.CategoryDTO;
import com.example.blogapp.blogapplication.entities.Category;
import com.example.blogapp.blogapplication.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    //create

    @PostMapping("/")
    public ResponseEntity<CategoryDTO> createCategory(@Validated @RequestBody CategoryDTO categoryDTO){
        CategoryDTO createCategoryDTO = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<CategoryDTO>(createCategoryDTO, HttpStatus.CREATED);
    }
    //update
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> updateCategory (@Validated@RequestBody CategoryDTO categoryDTO, @PathVariable Integer categoryId){
        CategoryDTO updateCategory = categoryService.updateCategory(categoryDTO,categoryId);
        return new ResponseEntity<CategoryDTO>(updateCategory, HttpStatus.OK);
    }
    //delete
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<APIResponse> deleteCategory(@PathVariable Integer categoryId){
        categoryService.deleteCatefory(categoryId);
        return new ResponseEntity(Map.of("message","Category deleted successfully"),HttpStatus.OK);
        //return new ResponseEntity<APIResponse>(new APIResponse("Category is deleted successfully", true),HttpStatus.OK);
    }
    //get
    @GetMapping("/{categoryId}")
    public  ResponseEntity<CategoryDTO> getCategory(@PathVariable Integer categoryId){
        CategoryDTO categoryDTO = categoryService.getCategory(categoryId);
        return new ResponseEntity<CategoryDTO>(categoryDTO, HttpStatus.OK);
    }
    //getAll

    @GetMapping("/")
    public ResponseEntity<List<CategoryDTO>> getCategories(){
        List<CategoryDTO>  allCategories = categoryService.getAllCategories();
        return  ResponseEntity.ok(allCategories);
    }



}
