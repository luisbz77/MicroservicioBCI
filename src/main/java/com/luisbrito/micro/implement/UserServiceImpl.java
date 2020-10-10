package com.luisbrito.micro.implement;

import com.luisbrito.micro.entity.UserEntity;
import com.luisbrito.micro.exceptions.PasswordNotMatchException;
import com.luisbrito.micro.exceptions.UserNotFoundException;
import com.luisbrito.micro.model.User;
import com.luisbrito.micro.repository.UserRepository;
import com.luisbrito.micro.service.UserService;
import com.luisbrito.micro.utils.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UserServiceImpl implements UserService{

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private UserRepository userRepository;
    private final UserUtils userUtils;

    public UserServiceImpl(UserRepository userRepository, UserUtils userUtils) {
        this.userRepository = userRepository;
        this.userUtils = userUtils;
    }


    @Override
    public User authenticate(String email, String password) {
        logger.info("email: {}",email);
        logger.info("password: {}",password);
        UserEntity userEntity = userRepository.findByEmail(email);
        if(Objects.isNull(userEntity))
            throw new UserNotFoundException();
        if (!userEntity.getPassword().equals(password))
            throw new PasswordNotMatchException();
        return userUtils.toModel(userEntity);
    }

    @Override
    public boolean validEmail(String email) {
        Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @Override
    public boolean validPassword(String password) {
        Pattern pattern = Pattern.compile("(^[A-Z][a-z]+(\\d){2}$)|(^[a-z]+[A-Z](\\d){2}$)|(^(\\d){2}[A-Z]{1}[a-z]+$)|(^[a-z]+(\\d){2}[A-Z])");
        Matcher matcher = pattern.matcher(password);
        return  matcher.matches();
    }

    @Override
    public User createdUser(User user) {
        UserEntity userEntity = userRepository.findByEmail(user.getEmail());
        if (Objects.nonNull(userEntity))
            return null;
        return userRepository.save(user);
       /* Optional.ofNullable(user.getEmail())
                .map(authenticationGateway::authorize)
                .ifPresent(user::setToken);
        return userMapper.toModel(userRepository.save(userMapper.toEntity(user)));¨*/
    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}
