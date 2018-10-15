package com.infotech.CustomSignUpLogin.exception;

import org.springframework.http.HttpStatus;

public enum SignUpErrorType implements ApiErrorType<SignUpErrorType> {

    INVALID_USERNAME_LENGTH(1001, "Username must consists of 3 characters"),
    INVALID_EMAIL_FORMAT(1002, "Email format is not valid"),
    INVALID_PASSWORD_LENGTH(1003, "Password must consists of 8 characters"),
    USERNAME_ALREADY_EXISTS(1004, "Username already exists"),
    SUCCESSFUL_REGISTRATION(1005, "User registered successfully");

    private Integer errorCode;
    private String errorMessage;

    SignUpErrorType(Integer errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }


    @Override
    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public Integer getErrorCode() {
        return errorCode;
    }
}
