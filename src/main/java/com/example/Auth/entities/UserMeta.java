package com.example.Auth.entities;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserMeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
    
    private boolean verified;

    @Column(name="wallet_balance")
    private double wallet_balance = 0.0;


    public boolean isVerified() {
        return verified;
    }

}
