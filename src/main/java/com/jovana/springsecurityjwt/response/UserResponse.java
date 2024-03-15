package com.jovana.springsecurityjwt.response;

import lombok.Builder;

@Builder
public record UserResponse(String username) {
}
