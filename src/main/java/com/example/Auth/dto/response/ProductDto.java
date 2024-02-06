package com.example.Auth.dto.response;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.example.Auth.entities.Images;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private int id;
    private String productName;
    private String productDescription;
    private BigDecimal price;
    private int stock;
    private String unit;
    private CategoryDto category;

    @Value("${prebook:false}")
    private boolean prebook;

    private List<ImageDto> images = new ArrayList<>();

    public void addImage(Images image) {
        ImageDto imageDTO = new ImageDto();
        imageDTO.setId(image.getId());
        imageDTO.setImg_url("https://d13aa073e03zd2.cloudfront.net/" + image.getImg_url());

        images.add(imageDTO);

    }
}
