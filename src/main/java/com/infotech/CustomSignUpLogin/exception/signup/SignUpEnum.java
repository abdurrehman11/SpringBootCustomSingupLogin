package com.infotech.CustomSignUpLogin.exception.signup;

public enum SignUpEnum {

    SUCCESS_FALSE("false", 0),
    SUCCESS_TRUE("true", 1),
    INVALID_USERNAME_LENGTH("Username must consists of 3 characters", 1001),
    INVALID_EMAIL_FORMAT("Email format is not valid", 1002),
    INVALID_PASSWORD_LENGTH("Password must consists of 8 characters", 1003),
    USERNAME_ALREADY_EXISTS("Username already exists", 1004),
    SUCCESSFUL_REGISTRATION("User registered successfully", 1005);

    private final String key;
    private final Integer value;

    SignUpEnum(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }
    public Integer getValue() {
        return value;
    }

}
