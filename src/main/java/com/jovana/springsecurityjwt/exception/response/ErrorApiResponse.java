package com.jovana.springsecurityjwt.exception.response;

import com.jovana.springsecurityjwt.exception.ApiException;
import com.jovana.springsecurityjwt.exception.CommonMessageResolver;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Setter
@Accessors(chain = true, fluent = true)
@Getter
public class ErrorApiResponse extends Response {
    private LocalDateTime timestamp;
    private int statusCode;

    private HttpStatus status;

    private String message;

    public ErrorApiResponse(ApiException exception, CommonMessageResolver messageResolver) {
        super(
                LocalDateTime.now(),
                exception.responseStatus().value(),
                exception.responseStatus(),
                messageResolver.get(exception.messageCode(), exception.messageArgs()),
                exception.details(),
                messageResolver.get(exception.actionCode(), exception.messageArgs())
        );

    }
}
