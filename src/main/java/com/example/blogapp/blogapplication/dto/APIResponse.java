package com.example.blogapp.blogapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIResponse {
    private String message;
    private boolean success;

//    public APIResponse(String message, boolean b) {
//        this.message = message;
//        this.success = b;
//    }
}
