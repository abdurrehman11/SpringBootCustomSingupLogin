package com.infotech.CustomSignUpLogin.controller;

import com.infotech.CustomSignUpLogin.config.CachedData;
import com.infotech.CustomSignUpLogin.exception.Response;
import com.infotech.CustomSignUpLogin.model.Exceptions;
import com.infotech.CustomSignUpLogin.model.User;
import com.infotech.CustomSignUpLogin.pojo.LoginRequest;
import com.infotech.CustomSignUpLogin.pojo.LoginResponse;
import com.infotech.CustomSignUpLogin.service.ExceptionService;
import com.infotech.CustomSignUpLogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    private UserService userService;
    private ExceptionService exceptionService;

    @Autowired
    public UserController(UserService userService, ExceptionService exceptionService) {
        this.userService = userService;
        this.exceptionService = exceptionService;
    }

    @PostMapping("/signup")
    public User registerUser(@Valid @RequestBody User user) {

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
//
//    @GetMapping("/exceptions")
//    public String getAllExceptions() {
//        List<Exceptions> exceptions = exceptionService.getAllExceptions();
//        System.out.println(exceptions);
//        return "Get exceptions";
//    }
//
//    @GetMapping("/exception")
//    public String getExceptionById() {
//        Exceptions exception = exceptionService.getExceptionById(2L);
//        System.out.println(exception);
//        return "Get exception";
//    }
}
