package com.luisbrito.micro.service;

import com.luisbrito.micro.model.LoginRequest;
import com.luisbrito.micro.model.User;

public interface LoginUserService {
    User doLogin(LoginRequest loginRequest);

}
