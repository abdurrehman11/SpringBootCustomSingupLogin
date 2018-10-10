package com.infotech.CustomSignUpLogin.exception;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private ApiErrorType apiErrorType;

    public ResourceNotFoundException(ApiErrorType apiErrorType) {
        this.apiErrorType = apiErrorType;
    }

    public ApiErrorType getApiErrorType() {
        return apiErrorType;
    }

    public void setApiErrorType(ApiErrorType apiErrorType) {
        this.apiErrorType = apiErrorType;
    }
}
