package com.infotech.CustomSignUpLogin.service;

import com.infotech.CustomSignUpLogin.config.CachedData;
import com.infotech.CustomSignUpLogin.model.Exceptions;
import com.infotech.CustomSignUpLogin.repository.ExceptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExceptionService {

//    @Autowired
//    private ExceptionRepository exceptionRepository;
//
//    @Autowired
//    CacheManager cacheManager;
//
//    @Cacheable(cacheNames = "exceptionCache", key = "#result.forEach()}")
//    public List<Exceptions> getAllExceptions() {
//        List<Exceptions> exceptions = exceptionRepository.findAll();
//        //cacheAll(exceptions);
//        return exceptions;
//    }
//
//
//    public void cacheAll(List<Exceptions> exceptions) {
//        for (Exceptions exception: exceptions) {
//            cacheManager.getCache("exceptionCache").putIfAbsent(exception.getId(), exception);
//        }
//    }
//
//
//    @Cacheable(value = "exceptionCache")
//    public Exceptions getExceptionById(Long exceptionId) {
//        Exceptions exception =  exceptionRepository.findById(exceptionId).get();
//        return exception;
//    }
}
