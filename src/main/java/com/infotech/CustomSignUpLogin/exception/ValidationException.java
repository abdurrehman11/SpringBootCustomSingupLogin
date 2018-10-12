package com.infotech.CustomSignUpLogin.exception;

public class ValidationException extends BaseException {

    protected ValidationException(Exception ex) {
        super(ex);
    }

    public ValidationException(ApiErrorType<? extends Enum<?>> apiErrorType) {
        super(apiErrorType);
    }

    protected ValidationException(ApiErrorType<? extends Enum<?>> apiErrorType, Exception ex) {
        super(apiErrorType, ex);
    }

}
