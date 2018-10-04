package com.infotech.CustomSignUpLogin.exception.signup;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class SignUpExceptionController {

    @ExceptionHandler(value = SignUpException.class)
    @ResponseBody
    public SignUpResponse handleSignUpException(SignUpException exception) {

        SignUpResponse response = new SignUpResponse(exception.getMessage(), exception.getSuccess());
        return response;
    }
}
