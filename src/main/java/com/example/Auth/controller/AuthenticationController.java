package com.example.Auth.controller;

import com.example.Auth.dto.request.RefreshTokenRequest;
import com.example.Auth.dto.request.SignInRequest;
import com.example.Auth.dto.request.SignUpRequest;
import com.example.Auth.dto.response.JwtAuthenticationResponse;
import com.example.Auth.entities.User;
import com.example.Auth.services.AuthenticationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @GetMapping("/demo")
    public ResponseEntity<String> customerHome() {
        return ResponseEntity.ok("Hi Customer");
    }
    
    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody @Valid SignUpRequest signUpRequest) {
        return ResponseEntity.ok(authenticationService.signUp(signUpRequest));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody @Valid SignInRequest signInRequest) {
        return ResponseEntity.ok(authenticationService.signIn(signInRequest));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
    }
    

}
