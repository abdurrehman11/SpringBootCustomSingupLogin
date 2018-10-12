package com.infotech.CustomSignUpLogin.exception;

import org.springframework.http.HttpStatus;

public abstract class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    protected HttpStatus httpStatus;
    protected String errorMessage;
    protected Integer errorCode;


    protected BaseException (Exception ex, HttpStatus httpStatus) {
        super(ex);
        this.httpStatus = httpStatus;
        if (ex.getMessage() != null) {
            this.errorMessage = ex.getMessage();
            this.errorCode = null;
        } else {
            this.errorMessage = GeneralException.SOMETHING_WENT_WRONG.getErrorMessage();
            this.errorCode = GeneralException.SOMETHING_WENT_WRONG.getErrorCode();
        }
    }

    protected BaseException (ApiErrorType<? extends Enum<?>> apiErrorType, HttpStatus httpStatus) {
        super(apiErrorType.getMessage());
        this.httpStatus = httpStatus;
        this.errorMessage = apiErrorType.getMessage();
        this.errorCode = apiErrorType.getErrorCode();
    }

    protected BaseException (ApiErrorType<? extends Enum<?>> apiErrorType, String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
        this.errorMessage = message;
        this.errorCode = apiErrorType.getErrorCode();
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
