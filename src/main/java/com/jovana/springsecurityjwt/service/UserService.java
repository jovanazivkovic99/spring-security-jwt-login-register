package com.jovana.springsecurityjwt.service;

import com.jovana.springsecurityjwt.request.LoginRequest;
import com.jovana.springsecurityjwt.request.RegisterRequest;

public interface UserService {
    String loginAndGenerateToken(LoginRequest loginRequest);

    void register(RegisterRequest registerRequest);

}
