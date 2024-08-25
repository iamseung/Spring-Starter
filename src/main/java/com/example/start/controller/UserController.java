package com.example.start.controller;

import com.example.start.exception.ErrorCode;
import com.example.start.exception.ItemErrorException;
import com.example.start.exception.UserErrorException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/error")
    public void errorTest() {
        throw new UserErrorException(ErrorCode.NO_ARGUMENT);
    }
}
