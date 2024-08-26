package com.example.blogapp.demoblogapp.repositories;

import com.example.blogapp.demoblogapp.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository <Category, Integer>{

}
