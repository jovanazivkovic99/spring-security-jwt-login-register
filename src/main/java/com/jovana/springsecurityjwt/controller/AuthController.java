package com.jovana.springsecurityjwt.controller;

import com.jovana.springsecurityjwt.request.LoginRequest;
import com.jovana.springsecurityjwt.request.RegisterRequest;
import com.jovana.springsecurityjwt.response.LoginResponse;
import com.jovana.springsecurityjwt.response.UserResponse;
import com.jovana.springsecurityjwt.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        String token = userService.loginAndGenerateToken(loginRequest);
        return new LoginResponse(token);
    }

    @PostMapping("/register")
    public void register(@RequestBody @Valid RegisterRequest registerRequest) {
        userService.register(registerRequest);
    }
}
