package com.luisbrito.micro.service;

import com.luisbrito.micro.model.LoginRequest;
import com.luisbrito.micro.model.User;
import org.springframework.stereotype.Service;

@Service
public interface LoginUserService {
    User doLogin(LoginRequest loginRequest);

}
