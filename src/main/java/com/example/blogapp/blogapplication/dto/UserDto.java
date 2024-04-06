package com.example.blogapp.blogapplication.dto;



import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class UserDto {
    private int id;
    @NotEmpty @Length(min = 4,message = "Username must be min of 4 characters!!")
    private String name;
    @NotEmpty
    @Email(message = "Email address is invalid")
    private String email;

    @NotEmpty
    @Length ( min = 3, max = 10, message = "Password must be min of 3 chars and max of 10 chars !!")
     private String password;

    @NotBlank
    private String about;

}
