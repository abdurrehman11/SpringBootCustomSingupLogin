package com.infotech.CustomSignUpLogin.exception;

public enum GeneralException {

    SOMETHING_WENT_WRONG(9999, "Something went wrong.");

    private Integer code;
    private String message;

    GeneralException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getErrorCode() {
        return code;
    }

    public String getErrorMessage() {
        return message;
    }
}
