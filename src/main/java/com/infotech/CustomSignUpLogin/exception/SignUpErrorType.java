package com.infotech.CustomSignUpLogin.exception;

public enum SignUpErrorType implements ApiErrorType {

    INVALID_USERNAME_LENGTH(1001, "Username must consists of 3 characters"),
    INVALID_EMAIL_FORMAT(1002, "Email format is not valid"),
    INVALID_PASSWORD_LENGTH(1003, "Password must consists of 8 characters"),
    SUCCESSFUL_REGISTRATION(1005, "User registered successfully"),

    USERNAME_ALREADY_EXISTS(1004);

    private String message = "";
    private Integer code;

    SignUpErrorType(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    SignUpErrorType(Integer code) {
        this.code = code;
    }

//    SignUpErrorType(int code, String ... values) {
//        this.code = code;
//        for (String value: values) {
//            this.message += value;
//        }
//    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String ... values) {
        for (String value: values) {
            this.message += value;
        }
    }

    @Override
    public Integer getErrorCode() {
        return code;
    }


}
