package com.infotech.CustomSignUpLogin;

import com.infotech.CustomSignUpLogin.config.CachedData;
import com.infotech.CustomSignUpLogin.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableCaching
public class CustomSignUpLoginApplication {

	@Autowired
	private ExceptionService exceptionService;

	public static void main(String[] args) {
		SpringApplication.run(CustomSignUpLoginApplication.class, args);
	}

	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager("exceptionCache");
	}

	@PostConstruct
	public void fetchExceptionsInCache() {
		CachedData.exceptions =  exceptionService.getAllExceptions();
	}

}
