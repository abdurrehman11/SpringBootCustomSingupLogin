package com.infotech.CustomSignUpLogin.repository;

import com.infotech.CustomSignUpLogin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
