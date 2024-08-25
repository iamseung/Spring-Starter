package com.example.start.exception;

public class UserErrorException extends RuntimeException{
    private final ErrorCode errorCode;
    private final String message;

    public UserErrorException(ErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public UserErrorException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.message = errorCode.message;
    }

    @Override
    public String getMessage() {
//        return "[%s] %s".formatted(errorCode, message);
        return message;
    }
}
