package com.example.Auth.dto.request;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddProductRequest {
    // @NotBlank(message = "name is required")
    private String productName;

    // @NotBlank(message = "productDescription is required")
    private String productDescription;

    // @NotBlank(message = "proce is required")
    private BigDecimal price;

    // @NotBlank(message = "stock is required")
    private int stock;

    // @NotBlank(message = "unit is required")
    private String unit;

    @Value("${prebook:false}")
    private boolean prebook;

    // @NotBlank(message = "category_id is required")
    private int category_id;

    // @NotBlank(message = "farm_id is required")
    private int farm_id;
}
