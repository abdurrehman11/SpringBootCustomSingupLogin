package com.infotech.CustomSignUpLogin.exception;

import com.infotech.CustomSignUpLogin.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = ServiceException.class)
    public Response handleException (ServiceException ex) {

       Response response = new Response(HttpStatus.BAD_REQUEST.value(), ex.getApiErrorType().getMessage());
       return response;
    }
}
