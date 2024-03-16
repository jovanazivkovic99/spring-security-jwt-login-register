package com.jovana.springsecurityjwt.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Getter
@Setter
@Accessors(fluent = true)
public abstract class ApiException extends RuntimeException {

    protected Map<?, ?> details;
    private HttpStatus responseStatus;
    private String actionCode;
    private String messageCode;

    protected ApiException(String actionCode, String messageCode, HttpStatus responseStatus, Map<?,?> details) {
        this.responseStatus = responseStatus;
        this.actionCode = actionCode;
        this.messageCode = messageCode;
        this.details = details;
    }

    public abstract Object[] messageArgs();
}
