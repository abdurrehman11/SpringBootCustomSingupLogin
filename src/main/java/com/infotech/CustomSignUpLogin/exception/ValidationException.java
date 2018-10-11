package com.infotech.CustomSignUpLogin.exception;

public class ValidationException extends BaseException {

    public ValidationException(ApiErrorType apiErrorType) {
        super(apiErrorType);
    }
}
