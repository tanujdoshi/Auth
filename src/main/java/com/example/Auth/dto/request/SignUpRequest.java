package com.example.Auth.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {
    @NotNull(message = "First Name is required")
    private String firstName;
    @NotNull(message = "Last Name is required")
    private String lastName;
    @NotNull(message = "Password is required")
    private String password;
    @NotNull(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;
    private com.example.Auth.entities.Role role;
  
}
