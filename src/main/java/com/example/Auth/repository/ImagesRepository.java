package com.example.Auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Auth.entities.Images;

public interface ImagesRepository extends JpaRepository<Images, Integer>{
    
}
