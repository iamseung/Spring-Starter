package com.example.start.exception;

public class ItemErrorException extends RuntimeException {
    private final ErrorCode errorCode;
    private final String message;

    public ItemErrorException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.message = errorCode.message;
    }

    @Override
    public String getMessage() {
//        return "[%s] %s".formatted(errorCode, message);
        return message;
    }
}
