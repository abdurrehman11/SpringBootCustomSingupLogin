package com.infotech.CustomSignUpLogin.repository;

import com.infotech.CustomSignUpLogin.model.Exceptions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExceptionRepository extends JpaRepository<Exceptions, Long> {

}
