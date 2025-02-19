package com.cars24.csms.data.res;

import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Valid
public class ApiResponse {
    private int statusCode;
    private boolean success;
    private Object data;
    private String service;
    private String message;
}
