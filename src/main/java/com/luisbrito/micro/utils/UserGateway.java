package com.luisbrito.micro.utils;


import com.luisbrito.micro.model.User;

public interface UserGateway {

    User authenticate(String email, String password);

    boolean validEmail(String email);

    boolean validPassword(String password);

    User createdUser(User user);

    User updateUser(User user);
}
