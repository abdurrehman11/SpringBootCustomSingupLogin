package com.infotech.CustomSignUpLogin.config;

import com.infotech.CustomSignUpLogin.model.Exceptions;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CachedData {

    public static List<Exceptions> exceptions = new ArrayList<>();
}
