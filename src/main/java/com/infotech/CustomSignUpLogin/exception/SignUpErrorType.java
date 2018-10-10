package com.infotech.CustomSignUpLogin.exception;

public enum SignUpErrorType implements ApiErrorType {

    INVALID_USERNAME_LENGTH("Username must consists of 3 characters", 1001),
    INVALID_EMAIL_FORMAT("Email format is not valid", 1002),
    INVALID_PASSWORD_LENGTH("Password must consists of 8 characters", 1003),
    USERNAME_ALREADY_EXISTS("Username already exists", 1004),
    SUCCESSFUL_REGISTRATION("User registered successfully", 1005);

    private String message;
    private Integer code;

    SignUpErrorType(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
