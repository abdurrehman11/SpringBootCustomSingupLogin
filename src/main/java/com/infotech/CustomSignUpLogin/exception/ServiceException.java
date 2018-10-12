package com.infotech.CustomSignUpLogin.exception;

import org.springframework.http.HttpStatus;

public class ServiceException extends BaseException {


    public ServiceException(ApiErrorType apiErrorType, HttpStatus httpStatus) {
        super(apiErrorType, httpStatus);
    }
}
