package com.example.Auth.services.impl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Auth.dto.request.AddFarmRequest;
import com.example.Auth.dto.request.AddProductRequest;
import com.example.Auth.dto.response.CategoryDto;
import com.example.Auth.dto.response.FarmDto;
import com.example.Auth.dto.response.ProductDto;
import com.example.Auth.entities.Category;
import com.example.Auth.entities.Farms;
import com.example.Auth.entities.Images;
import com.example.Auth.entities.Product;
import com.example.Auth.entities.User;
import com.example.Auth.repository.CategoryRepository;
import com.example.Auth.repository.FarmRepository;
import com.example.Auth.repository.ImagesRepository;
import com.example.Auth.repository.ProductRepository;
import com.example.Auth.repository.UserRepository;
import com.example.Auth.services.ProductService;
import com.example.Auth.utils.Awsutils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final FarmRepository farmRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final Awsutils awsutils;
    private final ImagesRepository imagesRepository;

    @Override
    public List<ProductDto> addProduct(AddProductRequest AddProductRequest, final MultipartFile[] multipartFiles,
            Principal principal) {
        try {

            Farms farm = farmRepository.findById(AddProductRequest.getFarm_id());

            Category category = categoryRepository.findById(AddProductRequest.getCategory_id());

            Product product = modelMapper.map(AddProductRequest, Product.class);
            product.setFarm(farm);
            product.setCategory(category);
            Product savedProduct = productRepository.save(product);

            List<Images> productImages = new ArrayList<>();
            for (MultipartFile file : multipartFiles) {
                String url = awsutils.uploadFileToS3(file, "PRODUCT", savedProduct.getId());
                Images image = new Images();
                image.setProduct(savedProduct);
                image.setImg_url(url);
                imagesRepository.save(image);
                System.out.println("-=-=-=-=- " + url);
                productImages.add(image);
            }
            product.setImages(productImages);

            List<Product> userProducts = productRepository.findByFarm(farm);
            return userProducts.stream().map(this::convertProductResponse).collect(Collectors.toList());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            List<ProductDto> products = new ArrayList<>();
            return products;
        }
    }

    private ProductDto convertProductResponse(Product product) {
        long startTime = System.nanoTime();
        ProductDto dto = new ProductDto();
        dto.setProductName(product.getProductName());
        dto.setId(product.getId());
        dto.setStock(product.getStock());
        dto.setPrice(product.getPrice());
        dto.setUnit(product.getUnit());

        Category category = product.getCategory();

        for (Images images : product.getImages()) {
            dto.addImage(images);
        }

        long afterS3 = System.nanoTime();
        System.out.println("Time AFTERR IMAGES DTOOOOO: " + (afterS3 - startTime) / 1e6 + " milliseconds");
        if (category != null) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(category.getId());
            categoryDto.setName(category.getName());
            dto.setCategory(categoryDto);
        }
        return dto;
    }

}
