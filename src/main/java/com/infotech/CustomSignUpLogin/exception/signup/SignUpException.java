package com.infotech.CustomSignUpLogin.exception.signup;

public class SignUpException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String message;
    private String success;

    public SignUpException() {
    }

    public SignUpException(String message, String success) {
        this.message = message;
        this.success = success;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}

