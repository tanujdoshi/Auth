package com.example.Auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Auth.dto.request.AddFarmRequest;
import com.example.Auth.dto.response.FarmDto;
import com.example.Auth.services.FarmerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import java.util.Map;
import java.security.Principal;
import com.example.Auth.entities.Farms;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/farmer")
@RequiredArgsConstructor
public class FarmerController {
    
    private final FarmerService farmerService;
    @GetMapping
    public ResponseEntity<String> farmerHome() {
        return ResponseEntity.ok("Hi Farmer");
    }
    
    @PostMapping("/addfarm")
    public ResponseEntity<Map> addFarm(@ModelAttribute AddFarmRequest farmRequest, @RequestPart(value="files") MultipartFile[] files, Principal principal) {
        // System.out.println("Principallll:" + principal.getName());
        List<FarmDto> AllFarmerFarms = farmerService.addFarm(farmRequest, files, principal);
        Map<String, Object> response = new HashMap<>();

        response.put("message", principal.getName());
        response.put("Farmsss", AllFarmerFarms);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    
}
