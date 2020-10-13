package com.luisbrito.micro.service;

import com.luisbrito.micro.model.User;

import java.io.IOException;

public interface UserService {
    User authenticate (String email, String password);

    boolean validEmail (String email);

    boolean validPassword(String password);

    User createdUser (User user);
}
