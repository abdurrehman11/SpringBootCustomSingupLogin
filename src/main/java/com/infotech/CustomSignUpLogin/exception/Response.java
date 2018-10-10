package com.infotech.CustomSignUpLogin.exception;

import org.springframework.http.HttpStatus;

public class Response<T> {

    private Integer status_code;
    private Integer error_code;
    private String message;
    private T body;

    public Response() {
    }

    public Response(Integer status_code, String message, T body) {
        this.status_code = status_code;
        this.message = message;
        this.body = body;
    }

    public Integer getStatus_code() {
        return status_code;
     }

    public void setStatus_code(Integer status_code) {
        this.status_code = status_code;
    }

    public Integer getError_code() {
        return error_code;
    }

    public void setError_code(Integer error_code) {
        this.error_code = error_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

}
