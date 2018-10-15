package com.infotech.CustomSignUpLogin.exception;

public class ErrorResponse extends Response {

    private Integer errorCode;

    public ErrorResponse(Integer httpStatus, String errorMessage, Integer errorCode) {
        super(httpStatus, errorMessage);
        this.errorCode = errorCode;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
