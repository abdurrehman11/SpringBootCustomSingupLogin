package com.infotech.CustomSignUpLogin.exception;

public enum GeneralException {

    ERROR_DESCRIPTION(9999, "Something went wrong.");

    private Integer code;
    private String error_message;

    GeneralException(Integer code, String error_message) {
        this.code = code;
        this.error_message = error_message;
    }

    public Integer getErrorCode() {
        return code;
    }

    public String getErrorMessage() {
        return error_message;
    }
}
