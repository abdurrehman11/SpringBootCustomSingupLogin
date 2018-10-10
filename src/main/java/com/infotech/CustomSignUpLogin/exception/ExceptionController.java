package com.infotech.CustomSignUpLogin.exception;

import com.infotech.CustomSignUpLogin.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<Object> handleException (ResourceNotFoundException ex) {

        Response<User> user = new Response<>();
        user.setStatus_code(HttpStatus.NOT_FOUND.value());
        user.setError_code(ex.getApiErrorType().getCode());
        user.setMessage(ex.getApiErrorType().getMessage());

        return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
    }
}
