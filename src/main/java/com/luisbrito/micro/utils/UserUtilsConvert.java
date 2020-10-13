package com.luisbrito.micro.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luisbrito.micro.entity.UserEntity;
import com.luisbrito.micro.exceptions.PhoneException;
import com.luisbrito.micro.model.User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserUtilsConvert implements UserUtils{
    private ObjectMapper objectMapper;

    public UserUtilsConvert(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public UserEntity toEntity(User user) {
        try{
            return UserEntity.builder()
                    .name(user.getName())
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .phones(objectMapper.writeValueAsString(user.getPhones()))
                    .created(Optional.ofNullable(user.getCreated()).orElse(new Timestamp(System.currentTimeMillis())))
                    .modified(Optional.ofNullable(user.getModified()).orElse(new Timestamp(System.currentTimeMillis())))
                    .lastLogin(Optional.ofNullable(user.getLastLogin()).orElse(new Timestamp(System.currentTimeMillis())))
                    .isActive(true)
                    .token(user.getToken())
                    .build();
        }catch (JsonProcessingException e){
            throw new PhoneException();
        }
    }

    @Override
    public User toModel(UserEntity userEntity){
        try {
            return User.builder()
                    .id(userEntity.getId())
                    .name(userEntity.getName())
                    .email(userEntity.getEmail())
                    .password(userEntity.getPassword())
                    .phones(objectMapper.readValue(userEntity.getPhones(), ArrayList.class))
                    .created(Optional.ofNullable(userEntity.getCreated()).orElse(new Timestamp(System.currentTimeMillis())))
                    .modified(Optional.ofNullable(userEntity.getModified()).orElse(new Timestamp(System.currentTimeMillis())))
                    .lastLogin(Optional.ofNullable(userEntity.getLastLogin()).orElse(new Timestamp(System.currentTimeMillis())))
                    .isActive(true)
                    .token(userEntity.getToken())
                    .build();
        }catch(JsonProcessingException e){
            throw new PhoneException();
        }
    }
}
