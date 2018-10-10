package com.infotech.CustomSignUpLogin.exception;

import com.infotech.CustomSignUpLogin.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = ServiceException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response handleValidationException (ServiceException ex) {

       Response response = new Response(HttpStatus.BAD_REQUEST.value(), ex.getApiErrorType().getMessage());
       return response;
    }

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response handleGeneralException() {

        Response response = new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Something went wrong.");
        return response;
    }

}
