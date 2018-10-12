package com.infotech.CustomSignUpLogin.exception;

public interface ApiErrorType<E extends Enum<E>> {

    String getErrorMessage();
    Integer getErrorCode();
}
