package com.infotech.CustomSignUpLogin.controller;

import com.infotech.CustomSignUpLogin.exception.signup.SignUpResponse;
import com.infotech.CustomSignUpLogin.model.User;
import com.infotech.CustomSignUpLogin.pojo.LoginRequest;
import com.infotech.CustomSignUpLogin.pojo.LoginResponse;
import com.infotech.CustomSignUpLogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public SignUpResponse registerUser(@Valid @RequestBody User user) {

        return userService.registerUser(user);
    }

    @PostMapping("/signin")
    public LoginResponse loginUser(@Valid @RequestBody LoginRequest loginRequest) {

        return userService.loginUser(loginRequest);
    }

    @GetMapping("/verifyToken")
    public Long verifyToken(@RequestParam("token")  String token) {

        return userService.verifyToken(token);
    }
}
