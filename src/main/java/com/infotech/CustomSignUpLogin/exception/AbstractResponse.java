package com.infotech.CustomSignUpLogin.exception;

public abstract class AbstractResponse {

    private String message;
    private String success;

    public AbstractResponse(String message, String success) {
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
