package com.luisbrito.micro.utils;

import com.luisbrito.micro.entity.UserEntity;
import com.luisbrito.micro.model.User;

import java.io.IOException;

public interface UserUtils {
    UserEntity toEntity(User user);

    User toModel(UserEntity userEntity);
}
