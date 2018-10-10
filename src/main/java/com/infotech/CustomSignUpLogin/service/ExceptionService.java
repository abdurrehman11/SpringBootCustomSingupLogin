package com.infotech.CustomSignUpLogin.service;

import com.infotech.CustomSignUpLogin.config.CachedData;
import com.infotech.CustomSignUpLogin.model.Exceptions;
import com.infotech.CustomSignUpLogin.repository.ExceptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExceptionService {

    @Autowired
    private ExceptionRepository exceptionRepository;

//    @Cacheable(value = "exceptionCache")
    public List<Exceptions> getAllExceptions() {
//        if (CachedData.exceptions.isEmpty()) {
        return exceptionRepository.findAll();
//        }

//        return CachedData.exceptions;
    }


    public Exceptions getExceptionById(Long exceptionId) {
        Exceptions exception =  exceptionRepository.findById(exceptionId).get();
        return exception;
    }
}
