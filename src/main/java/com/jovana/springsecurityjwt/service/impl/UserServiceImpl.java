package com.jovana.springsecurityjwt.service.impl;

import com.jovana.springsecurityjwt.exception.user.UsernameAlreadyExistsException;
import com.jovana.springsecurityjwt.model.Role;
import com.jovana.springsecurityjwt.model.User;
import com.jovana.springsecurityjwt.repository.UserRepository;
import com.jovana.springsecurityjwt.request.LoginRequest;
import com.jovana.springsecurityjwt.request.RegisterRequest;
import com.jovana.springsecurityjwt.service.UserService;
import com.jovana.springsecurityjwt.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String loginAndGenerateToken(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password())
        );
        return jwtUtil.createToken(authentication);
    }

    @Override
    public void register(RegisterRequest registerRequest) {
        if (userRepository.findByUsername(registerRequest.username()).isPresent()) {
            throw new UsernameAlreadyExistsException("action.user.register",
                    "error.user.exists",
                    registerRequest.username(),
                    HttpStatus.CONFLICT);
        }

        User user = new User();
        user.setUsername(registerRequest.username());
        user.setPassword(passwordEncoder.encode(registerRequest.password()));
        try {
            Role role = Role.valueOf(registerRequest.role().toUpperCase());
            user.setRole(role);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid role provided");
        }
        userRepository.save(user);
    }
}
