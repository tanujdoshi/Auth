package com.example.Auth.services;

import java.security.Principal;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.Auth.dto.request.AddProductRequest;
import com.example.Auth.dto.response.ProductDto;

public interface ProductService {
    List<ProductDto> addProduct(AddProductRequest product, MultipartFile[] files, Principal principal);
}
