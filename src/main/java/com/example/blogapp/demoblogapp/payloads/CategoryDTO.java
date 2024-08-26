package com.example.blogapp.demoblogapp.payloads;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CategoryDTO {
    private Integer categoryId;
    private String categoryTitle;
    private String categoryDescription;
}
