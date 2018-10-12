package com.infotech.CustomSignUpLogin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ExceptionController {

    @ResponseBody
    @ExceptionHandler(value = BaseException.class)
    public Response handleValidationException (BaseException ex, HttpServletRequest req, HttpServletResponse res) {

       Response response = new Response(ex.getHttpStatus().value(), ex.getErrorMessage(),
               ex.getErrorCode());
       res.setStatus(ex.getHttpStatus().value());
       return response;
    }


    @ResponseBody
    @ExceptionHandler(value = RuntimeException.class)
    public Response handleGeneralException() {

        Response response = new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), GeneralException.ERROR_DESCRIPTION.getErrorMessage(),
                GeneralException.ERROR_DESCRIPTION.getErrorCode());
        return response;
    }

}
