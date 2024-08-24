package com.example.start.dto.response;

import lombok.Getter;

@Getter
public class UserErrorResponse {
    private String error;

    public UserErrorResponse(String message) {
        this.error = message;
    }
}
