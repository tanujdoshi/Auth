package com.example.Auth.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@Entity
@Table(name = "images")
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String img_url;

    @ManyToOne
    @JoinColumn(name = "farm_id")
    @ToString.Exclude
    @JsonBackReference
    private Farms farm;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @ToString.Exclude
    @JsonBackReference
    private Product product;
}
