package com.example.Auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Auth.entities.Farms;
import com.example.Auth.entities.Product;
import com.example.Auth.entities.User;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByFarm(Farms farm);
}
