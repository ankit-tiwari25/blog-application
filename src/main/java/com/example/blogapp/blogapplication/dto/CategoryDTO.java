package com.example.blogapp.blogapplication.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class CategoryDTO {
    private Integer id;
    @NotBlank
    @NotEmpty
    @Length(min = 4, message = "Title should be minimun of 4 characters")
    private String title;

    @NotBlank
    @NotEmpty
    @Length(min = 5, message = "Description should be minimun of 5 characters")
    private String description;
}
