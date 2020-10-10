package com.luisbrito.micro.implement;

import com.luisbrito.micro.exceptions.BusinessException;
import com.luisbrito.micro.exceptions.InvalidEmailException;
import com.luisbrito.micro.exceptions.UserIsNullExeption;
import com.luisbrito.micro.model.LoginRequest;
import com.luisbrito.micro.model.User;
import com.luisbrito.micro.service.LoginUserService;
import com.luisbrito.micro.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class LoginUserServiceImpl implements LoginUserService {

    private static final Logger logger = LoggerFactory.getLogger(LoginUserServiceImpl.class);
    UserService userService;

    @Override
    public User doLogin(LoginRequest loginRequest) {
        validate(loginRequest);
        logger.info("Email user: {}",loginRequest.getEmail());
        logger.info("Password user: {}",loginRequest.getPassword());
        return userService.authenticate(loginRequest.getEmail(),loginRequest.getPassword());
    }

    private void validate(LoginRequest loginRequest){
        if (Objects.isNull(loginRequest))
            throw new UserIsNullExeption();
        if (!userService.validEmail(loginRequest.getEmail()))
            throw new InvalidEmailException();
        if(Objects.isNull(loginRequest.getPassword()) || loginRequest.getPassword().isEmpty())
            throw new BusinessException();
    }
}
