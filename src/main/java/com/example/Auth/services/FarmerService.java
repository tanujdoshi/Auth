package com.example.Auth.services;

import java.security.Principal;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.Auth.dto.request.AddFarmRequest;
import com.example.Auth.dto.response.FarmDto;
import com.example.Auth.entities.Farms;


public interface FarmerService {
    List<FarmDto> addFarm(AddFarmRequest farmRequest, MultipartFile[] files, Principal principal);
}
