package com.infotech.CustomSignUpLogin.exception.signup;

import com.infotech.CustomSignUpLogin.exception.AbstractException;

public class SignUpException extends AbstractException {

    private static final long serialVersionUID = 1L;

    public SignUpException(String message, String success) {
        super(message, success);
    }
}

