package com.example.Auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.Auth.entities.Farms;
import com.example.Auth.entities.User;

@Repository
public interface FarmRepository extends JpaRepository<Farms, Integer> {

    Farms findById(int id);

    List<Farms> findByUser(User user);
} 
