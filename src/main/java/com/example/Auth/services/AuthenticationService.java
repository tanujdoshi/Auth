package com.example.Auth.services;

import com.example.Auth.dto.request.RefreshTokenRequest;
import com.example.Auth.dto.request.SignInRequest;
import com.example.Auth.dto.request.SignUpRequest;
import com.example.Auth.dto.response.JwtAuthenticationResponse;
import com.example.Auth.entities.User;

public interface AuthenticationService {
    User signUp(SignUpRequest signUpRequest);

    JwtAuthenticationResponse signIn(SignInRequest signInRequest);

    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
