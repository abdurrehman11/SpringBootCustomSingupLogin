package com.infotech.CustomSignUpLogin.exception.signup;

public class SignUpResponse {

    private String message;
    private String success;

    public SignUpResponse() {
    }

    public SignUpResponse(String message, String success) {
        this.message = message;
        this.success = success;
    }

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
