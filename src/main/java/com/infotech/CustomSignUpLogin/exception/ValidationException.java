package com.infotech.CustomSignUpLogin.exception;

public class ValidationException extends ServiceException {

    public ValidationException(ApiErrorType apiErrorType) {
        super(apiErrorType);
    }
}
