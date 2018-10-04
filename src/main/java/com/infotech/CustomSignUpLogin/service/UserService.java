package com.infotech.CustomSignUpLogin.service;

import com.infotech.CustomSignUpLogin.exception.signup.SignUpEnum;
import com.infotech.CustomSignUpLogin.exception.signup.SignUpException;
import com.infotech.CustomSignUpLogin.exception.signup.SignUpResponse;
import com.infotech.CustomSignUpLogin.model.User;
import com.infotech.CustomSignUpLogin.pojo.LoginRequest;
import com.infotech.CustomSignUpLogin.pojo.LoginResponse;
import com.infotech.CustomSignUpLogin.repository.UserRepository;
import com.infotech.CustomSignUpLogin.security.JwtTokenProvider;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public SignUpResponse registerUser(User user) {

        if (user.getUsername().length() < 3)
            throw new SignUpException(SignUpEnum.INVALID_USERNAME_LENGTH.getKey(), SignUpEnum.SUCCESS_FALSE.getKey());

        if (!EmailValidator.getInstance().isValid(user.getEmail()))
            throw new SignUpException(SignUpEnum.INVALID_EMAIL_FORMAT.getKey(), SignUpEnum.SUCCESS_FALSE.getKey());

        if (user.getPassword().length() < 8)
            throw new SignUpException(SignUpEnum.INVALID_PASSWORD_LENGTH.getKey(), SignUpEnum.SUCCESS_FALSE.getKey());

        if (userRepository.findByUsername(user.getUsername()) != null)
            throw new SignUpException(SignUpEnum.USERNAME_ALREADY_EXISTS.getKey(), SignUpEnum.SUCCESS_FALSE.getKey());

        User encryptedUser = new User(user.getUsername(), user.getEmail(), user.getPassword());
        encryptedUser.setPassword(passwordEncoder.encode(encryptedUser.getPassword()));
        userRepository.save(encryptedUser);
        return new SignUpResponse(SignUpEnum.SUCCESSFUL_REGISTRATION.getKey(), SignUpEnum.SUCCESS_TRUE.getKey());
    }

    public LoginResponse loginUser(LoginRequest loginRequest) {

        LoginResponse loginResponse = new LoginResponse();
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        User user = userRepository.findByUsername(username);

        if (user != null) {
            String encodedPassword = user.getPassword();
            boolean veriftyPassword = passwordEncoder.matches(password, encodedPassword);

            if (veriftyPassword) {
                String token = jwtTokenProvider.generateToken(user);
                System.out.println("token = " + token);
                loginResponse.setMessage("True");
                loginResponse.setToken(token);
            }
        }

        return loginResponse;
    }

    public Long verifyToken(String token) {

        Long id = null;
        boolean validToken = jwtTokenProvider.validateToken(token);
        if (validToken == true) {
            id = jwtTokenProvider.getUserIdFromJWT(token);
        }

        return id;
    }
}
