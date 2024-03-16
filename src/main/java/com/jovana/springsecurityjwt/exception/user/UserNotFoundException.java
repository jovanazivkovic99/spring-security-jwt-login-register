package com.jovana.springsecurityjwt.exception.user;

import com.jovana.springsecurityjwt.exception.ApiException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends ApiException {
    private final String username;

    public UserNotFoundException(String actionCode, String messageCode, String username, HttpStatus responseStatus) {
        super(actionCode, messageCode, responseStatus, null);
        this.username = username;
    }

    @Override
    public Object[] messageArgs() {
        return new Object[]{username};
    }
}
