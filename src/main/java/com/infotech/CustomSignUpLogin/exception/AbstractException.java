package com.infotech.CustomSignUpLogin.exception;

public abstract class AbstractException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String message;
    private String success;

    public AbstractException(String message, String success) {
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
