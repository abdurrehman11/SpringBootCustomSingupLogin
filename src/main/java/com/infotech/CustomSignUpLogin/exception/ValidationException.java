package com.infotech.CustomSignUpLogin.exception;

public class ValidationException extends BaseException {

    public ValidationException(ApiErrorType<? extends Enum<?>> apiErrorType) {
        super(apiErrorType);
    }
}
