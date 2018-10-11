package com.infotech.CustomSignUpLogin.exception;

public class Response {

    private Integer status_code;
    private String message;
    private Integer error_code;

    public Response(Integer status_code, String message, Integer error_code) {
        this.status_code = status_code;
        this.message = message;
        this.error_code = error_code;
    }

    public Integer getStatus_code() {
        return status_code;
     }

    public void setStatus_code(Integer status_code) {
        this.status_code = status_code;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getError_code() {
        return error_code;
    }

    public void setError_code(Integer error_code) {
        this.error_code = error_code;
    }
}
