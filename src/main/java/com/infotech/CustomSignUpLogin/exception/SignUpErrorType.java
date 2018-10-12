package com.infotech.CustomSignUpLogin.exception;

import org.springframework.http.HttpStatus;

public enum SignUpErrorType implements ApiErrorType<SignUpErrorType> {

    INVALID_USERNAME_LENGTH(1001, "Username must consists of 3 characters"),
    INVALID_EMAIL_FORMAT(1002, "Email format is not valid"),
    INVALID_PASSWORD_LENGTH(1003, "Password must consists of 8 characters"),
    USERNAME_ALREADY_EXISTS(1004, "Username already exists"),
    SUCCESSFUL_REGISTRATION(1005, "User registered successfully");

    private Integer error_code;
    private String message = "";

    SignUpErrorType(Integer error_code, String message) {
        this.error_code = error_code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }


    @Override
    public Integer getErrorCode() {
        return error_code;
    }

}
