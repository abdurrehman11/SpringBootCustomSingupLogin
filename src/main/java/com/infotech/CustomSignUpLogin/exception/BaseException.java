package com.infotech.CustomSignUpLogin.exception;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.http.HttpStatus;

public abstract class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private ApiErrorType apiErrorType;

    protected BaseException (Exception ex, ApiErrorType<? extends Enum<?>> apiErrorType) {
        super(ex);
        this.apiErrorType = apiErrorType;
    }

    protected BaseException (ApiErrorType<? extends Enum<?>> apiErrorType) {
        super(apiErrorType.getMessage());
        this.apiErrorType = apiErrorType;
    }

    public ApiErrorType getApiErrorType() {
        return apiErrorType;
    }
}
