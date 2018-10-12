package com.infotech.CustomSignUpLogin.exception;

import org.springframework.http.HttpStatus;

public class ValidationException extends BaseException {

    public ValidationException(Exception ex, HttpStatus httpStatus) {
        super(ex, httpStatus);
    }

    public ValidationException(ApiErrorType<? extends Enum<?>> apiErrorType, String message) {
        super(apiErrorType, message);
    }

    public ValidationException(ApiErrorType<? extends Enum<?>> apiErrorType, HttpStatus httpStatus) {
        super(apiErrorType, httpStatus);
    }

    public ValidationException(ApiErrorType<? extends Enum<?>> apiErrorType, String message, HttpStatus httpStatus) {
        super(apiErrorType, message, httpStatus);
    }

}
