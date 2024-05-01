package com.amaizing.crudtemplate.services;

import com.amaizing.crudtemplate.models.dtos.JwtResponse;
import com.amaizing.crudtemplate.models.dtos.UserDto;
import com.amaizing.crudtemplate.models.dtos.UserSignUpRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    ResponseEntity<String> createUser(UserSignUpRequest signUpRequest);

    ResponseEntity<JwtResponse> authenticate(String email, String password);

    ResponseEntity<UserDto> getUser(HttpServletRequest request);

    ResponseEntity<UserDto> updateUsername(String updateUsername, HttpServletRequest request);

}
