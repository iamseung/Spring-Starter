package com.example.start.exception;

public enum ErrorCode {
    NO_ARGUMENT("파라미터가 정확하지 않습니다.");

    public final String message;

    ErrorCode(String message) {
        this.message = message;
    }
}
