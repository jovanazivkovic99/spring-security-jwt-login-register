package com.jovana.springsecurityjwt.exception.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime timestamp;
    protected int statusCode;
    protected HttpStatus status;
    protected String message;
    protected Map<?, ?> data;
    protected String action;
}
