package com.cars24.csms.advice;

import com.cars24.csms.Exceptions.UserServiceException;
import com.cars24.csms.data.res.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
class GlobalExpectionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException exception)
    {
        ApiResponse apiResponse = new ApiResponse();
        log.info("[handleValidationExceptions]");
        Map<String,String> errorMap=new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error-> {
            errorMap.put(error.getField(),error.getDefaultMessage());
        });
        return ResponseEntity.ok().body(errorMap);
    }

    @ExceptionHandler(UserServiceException.class)
    public ResponseEntity<ApiResponse> handleUserServiceExceptions(UserServiceException exception) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setData(null);
        apiResponse.setMessage(exception.getMessage());
        apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        apiResponse.setSuccess(false);
        apiResponse.setService("APP_USER - " + HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.ok().body(apiResponse);
    }
}