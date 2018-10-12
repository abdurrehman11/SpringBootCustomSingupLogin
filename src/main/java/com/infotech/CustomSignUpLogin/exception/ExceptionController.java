package com.infotech.CustomSignUpLogin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ExceptionController {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = BaseException.class)
    public Response handleValidationException (BaseException ex) {

       Response response = new Response(ex.getHttpStatus().value(), ex.getErrorMessage(),
               ex.getErrorCode());
       return response;
    }


    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = RuntimeException.class)
    public Response handleGeneralException() {

        Response response = new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), GeneralException.SOMETHING_WENT_WRONG.getErrorMessage(),
                GeneralException.SOMETHING_WENT_WRONG.getErrorCode());
        return response;
    }

}
