package com.luisbrito.micro.controller;

import com.luisbrito.micro.model.LoginRequest;
import com.luisbrito.micro.model.User;
import com.luisbrito.micro.service.LoginUserService;
import com.luisbrito.micro.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class AppController {
    private static final Logger logger = LoggerFactory.getLogger(AppController.class);
    @Autowired
    private LoginUserService loginUserService;
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public User doLogin(@RequestBody LoginRequest loginRequest) throws IOException {return loginUserService.doLogin(loginRequest);
    }

    @PostMapping("/create")
    public User doCreate(@RequestBody User userRequest){return userService.createdUser(userRequest);}

}
