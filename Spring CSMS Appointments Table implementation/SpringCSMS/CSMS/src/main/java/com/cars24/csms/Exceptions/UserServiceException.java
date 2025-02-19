package com.cars24.csms.Exceptions;

import com.cars24.csms.data.res.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

public class UserServiceException extends RuntimeException{
    public UserServiceException(String message){
        super(message);
    }

}
