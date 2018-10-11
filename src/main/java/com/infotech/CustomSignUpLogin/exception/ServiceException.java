package com.infotech.CustomSignUpLogin.exception;

public class ServiceException extends BaseException {

    public ServiceException(ApiErrorType apiErrorType) {
        super(apiErrorType);
    }
}
