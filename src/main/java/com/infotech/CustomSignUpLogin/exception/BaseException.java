package com.infotech.CustomSignUpLogin.exception;

public abstract class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private ApiErrorType apiErrorType;

    protected BaseException (Exception ex) {
        super(ex);
    }

    protected BaseException (ApiErrorType<? extends Enum<?>> apiErrorType) {
        super(apiErrorType.getMessage());
        this.apiErrorType = apiErrorType;
    }

    protected BaseException (ApiErrorType<? extends Enum<?>> apiErrorType, Exception ex) {
        super(apiErrorType.getMessage(), ex);
        this.apiErrorType = apiErrorType;
    }

    public ApiErrorType getApiErrorType() {
        return apiErrorType;
    }

}
