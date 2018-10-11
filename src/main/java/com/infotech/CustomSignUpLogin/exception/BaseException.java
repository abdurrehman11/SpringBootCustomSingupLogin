package com.infotech.CustomSignUpLogin.exception;

public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private ApiErrorType apiErrorType;

    public BaseException (ApiErrorType apiErrorType) {
        this.apiErrorType = apiErrorType;
    }

    public ApiErrorType getApiErrorType() {
        return apiErrorType;
    }
}
