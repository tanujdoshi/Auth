package com.example.Auth.entities;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "name is required")
    private String productName;

    private String productDescription;

    private BigDecimal price;

    private int stock;

    private String unit;

    @Value("${prebook:false}")
    private boolean prebook;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @ToString.Exclude
    @JsonBackReference
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @ToString.Exclude
    @JsonManagedReference
    private List<Images> images;

    @ManyToOne
    @JoinColumn(name = "farm_id")
    @ToString.Exclude
    @JsonBackReference
    private Farms farm;

}
