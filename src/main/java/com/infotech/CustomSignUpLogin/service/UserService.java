package com.infotech.CustomSignUpLogin.service;

import com.infotech.CustomSignUpLogin.model.User;
import com.infotech.CustomSignUpLogin.pojo.LoginRequest;
import com.infotech.CustomSignUpLogin.pojo.LoginResponse;
import com.infotech.CustomSignUpLogin.repository.UserRepository;
import com.infotech.CustomSignUpLogin.security.JwtTokenProvider;
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

    public User registerUser(User user) {

        User encryptedUser = new User(user.getUsername(), user.getEmail(), user.getPassword());
        encryptedUser.setPassword(passwordEncoder.encode(encryptedUser.getPassword()));
        return userRepository.save(user);
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
