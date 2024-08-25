package com.example.start;

import com.example.start.dto.response.UserErrorResponse;
import com.example.start.exception.ItemErrorException;
import com.example.start.exception.UserErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiControllerAdvice {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
//    @ExceptionHandler(UserErrorException.class)
//    public ResponseEntity<?> userErrorHandler(UserErrorException exception) {
//        return ResponseEntity.status(401).build();
//    }

    @ExceptionHandler(UserErrorException.class)
    public UserErrorResponse userErrorHandler(UserErrorException exception) {
        log.info(exception.getMessage());
        return new UserErrorResponse(exception.getMessage());
    }

    @ExceptionHandler(ItemErrorException.class)
    public ResponseEntity<?> itemErrorHandler(ItemErrorException exception) {
        return ResponseEntity.status(401).build();
    }
}
