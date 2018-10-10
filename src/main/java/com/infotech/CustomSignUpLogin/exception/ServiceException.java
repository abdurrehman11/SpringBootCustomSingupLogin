package com.infotech.CustomSignUpLogin.exception;

public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private ApiErrorType apiErrorType;

    public ServiceException (ApiErrorType apiErrorType) {
        this.apiErrorType = apiErrorType;
    }

    public ApiErrorType getApiErrorType() {
        return apiErrorType;
    }
}
