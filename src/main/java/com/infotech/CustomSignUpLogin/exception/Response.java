package com.infotech.CustomSignUpLogin.exception;

public class Response {

    private Integer status_code;
    private String message;

    public Response(Integer status_code, String message) {
        this.status_code = status_code;
        this.message = message;
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

}
