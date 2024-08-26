package com.example.blogapp.demoblogapp.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private int id;

    @NotEmpty
    @Size(min=4, message="Username must be min of  characters !!")
    private String name;

    @NotEmpty
    @Email(message="Email address is not valid")
    private String email;

    @NotEmpty
    @Size(min=8, max = 20,message = "Password must be min of 3 chars and max of 10 chars")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$",
            message = "Password must be at least 8 characters long, contain at least one digit, one uppercase letter, one lowercase letter, and one special character.")
    private String password;

    @NotEmpty
    private String about;
}
