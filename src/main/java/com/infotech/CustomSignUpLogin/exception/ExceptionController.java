package com.infotech.CustomSignUpLogin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ExceptionController {

    @ResponseBody
    @ExceptionHandler(value = BaseException.class)
    public ErrorResponse handleValidationException (BaseException ex, HttpServletRequest req, HttpServletResponse res) {

        ErrorResponse errorResponse = new ErrorResponse(ex.getHttpStatus().value(), ex.getErrorMessage(),
               ex.getErrorCode());
       res.setStatus(ex.getHttpStatus().value());
       return errorResponse;
    }


    @ResponseBody
    @ExceptionHandler(value = RuntimeException.class)
    public ErrorResponse handleGeneralException(HttpServletRequest req, HttpServletResponse res) {

        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), GeneralErrorType.ERROR_DESCRIPTION.getErrorMessage(),
                GeneralErrorType.ERROR_DESCRIPTION.getErrorCode());
        res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return errorResponse;
    }

}
