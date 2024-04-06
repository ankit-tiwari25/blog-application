package com.example.blogapp.blogapplication.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @Column(name = "user_name", nullable = false, length = 200)
    private String email;
    private String password;
    private String about;
}
