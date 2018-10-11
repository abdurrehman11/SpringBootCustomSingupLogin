package com.infotech.CustomSignUpLogin.exception;

public interface ApiErrorType<E extends Enum<E>> {

    public String getMessage();
    public Integer getErrorCode();
}
