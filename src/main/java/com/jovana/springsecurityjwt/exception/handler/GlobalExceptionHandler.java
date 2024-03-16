package com.jovana.springsecurityjwt.exception.handler;

import com.jovana.springsecurityjwt.exception.ApiException;
import com.jovana.springsecurityjwt.exception.CommonMessageResolver;
import com.jovana.springsecurityjwt.exception.response.ErrorApiResponse;
import com.jovana.springsecurityjwt.exception.user.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {
    private final CommonMessageResolver messageResolver;

    @ExceptionHandler({
            UserNotFoundException.class
    })
    public ResponseEntity<ErrorApiResponse> handleExternalApiException(ApiException exception) {

        return new ResponseEntity<>(
                new ErrorApiResponse(exception, messageResolver),
                exception.responseStatus());
    }
}
