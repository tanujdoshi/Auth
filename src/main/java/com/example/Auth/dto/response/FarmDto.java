package com.example.Auth.dto.response;

import com.example.Auth.entities.Images;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.ArrayList;

@Getter
@Setter
public class FarmDto {
    private int id;
    private String name;
    private String Address;
    private int lat;
    private int lng;
    private List<ImageDto> images = new ArrayList<>();

    public void addImage(Images image) {
        ImageDto imageDTO = new ImageDto(); 
        imageDTO.setId(image.getId());
        imageDTO.setImg_url("https://d13aa073e03zd2.cloudfront.net/" + image.getImg_url());

        images.add(imageDTO);

    }

}
