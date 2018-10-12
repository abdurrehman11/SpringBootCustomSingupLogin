package com.infotech.CustomSignUpLogin.service;

import com.infotech.CustomSignUpLogin.exception.SignUpErrorType;
import com.infotech.CustomSignUpLogin.exception.ValidationException;
import com.infotech.CustomSignUpLogin.model.User;
import com.infotech.CustomSignUpLogin.pojo.LoginRequest;
import com.infotech.CustomSignUpLogin.pojo.LoginResponse;
import com.infotech.CustomSignUpLogin.repository.UserRepository;
import com.infotech.CustomSignUpLogin.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

        if (user.getUsername().length() < 3)
        {
            String id = "2";
            String myMessage = "Username already exists with id: " + id;
            // make your custom message and pass to enum
            throw new ValidationException(SignUpErrorType.USERNAME_ALREADY_EXISTS, myMessage, HttpStatus.NOT_FOUND);
        }
//            throw new ValidationException(SignUpErrorType.INVALID_USERNAME_LENGTH);


//        if (!EmailValidator.getInstance().isValid(user.getEmail()))
//            throw new SignUpException(SignUpEnum.INVALID_EMAIL_FORMAT.getKey(), SignUpEnum.SUCCESS_FALSE.getKey());
//
//        if (user.getPassword().length() < 8)
//            throw new SignUpException(SignUpEnum.INVALID_PASSWORD_LENGTH.getKey(), SignUpEnum.SUCCESS_FALSE.getKey());

//        User user2 = userRepository.findByUsername(user.getUsername());
////
//        if (userRepository.findByUsername(user.getUsername()) != null) {
//        }


        User user1 = userRepository.findByUsername(user.getUsername());
        System.out.println(user1.getEmail());

        User encryptedUser = new User(user.getUsername(), user.getEmail(), user.getPassword());
        encryptedUser.setPassword(passwordEncoder.encode(encryptedUser.getPassword()));
        userRepository.save(encryptedUser);

//        Response<User> userResponse = new Response<>();
//        userResponse.setStatus_code(HttpStatus.OK.value());
//        userResponse.setMessage(SignUpErrorType.SUCCESSFUL_REGISTRATION.getMessage());
//        userResponse.setBody(encryptedUser);

        return encryptedUser;
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
