package com.example.blogapp.demoblogapp.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Column(name = "user_name", nullable = false, length = 100)
    private String name;

    @NotNull
    @Email
    private String email;


    @NotNull
    private String password;

    @NotNull
    private String about;
}
