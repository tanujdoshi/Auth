package com.example.Auth.controller;

import com.example.Auth.dto.request.AddFarmRequest;
import com.example.Auth.dto.request.AddProductRequest;
import com.example.Auth.dto.response.FarmDto;
import com.example.Auth.dto.response.ProductDto;
import com.example.Auth.services.FarmerService;
import com.example.Auth.services.ProductService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import java.util.Map;
import java.security.Principal;
import com.example.Auth.entities.Farms;
import com.example.Auth.entities.Product;

import java.util.HashMap;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/farmer")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/addproduct")
    public ResponseEntity<Map> addProduct(@ModelAttribute @Valid AddProductRequest product,
            @RequestPart(value = "files") MultipartFile[] files, Principal principal) {
        // System.out.println("Principallll:" + principal.getName());
        List<ProductDto> AllFarmProducts = productService.addProduct(product, files,
                principal);
        Map<String, Object> response = new HashMap<>();

        response.put("message", principal.getName());
        response.put("Products", AllFarmProducts);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
