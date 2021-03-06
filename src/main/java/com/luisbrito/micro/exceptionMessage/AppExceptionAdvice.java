package com.luisbrito.micro.exceptionMessage;


import com.luisbrito.micro.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppExceptionAdvice {

    @ExceptionHandler(value = UserExistException.class)
    public ResponseEntity<Map<String,String>> handlerUserExistException(UserExistException userExistException){

        Map<String,String> map = new HashMap<>();
        map.put("mensaje","Usuario registrado con exito");
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = InvalidEmailException.class)
    public ResponseEntity<Map<String,String>> handlerInvalidEmailException(){

        Map<String,String> map = new HashMap<>();
        map.put("mensaje","Formato de correo incorrecto");
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = InvalidFormatException.class)
    public ResponseEntity<Map<String,String>> handlerInvalidFormatException(){

        Map<String,String> map = new HashMap<>();
        map.put("mensaje","Formato de contraseña incorrecto");
        return new ResponseEntity<>(map, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Map<String,String>> handlerUserNotFoundException(){

        Map<String,String> map = new HashMap<>();
        map.put("mensaje","Usuario no encontrado");
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UserIsNullExeption.class)
    public ResponseEntity<Map<String,String>> handlerUserIsNullExeption(){

        Map<String,String> map = new HashMap<>();
        map.put("mensaje","Usuario nulo");
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = PasswordNotMatchException.class)
    public ResponseEntity<Map<String,String>> handlerPasswordNotMatchException(){

        Map<String,String> map = new HashMap<>();
        map.put("mensaje","Contraseña incorrecta");
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = PhoneException.class)
    public ResponseEntity<Map<String,String>> handlerPhoneException(){

        Map<String,String> map = new HashMap<>();
        map.put("mensaje","No se pudieron procesar los teléfonos");
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

}
