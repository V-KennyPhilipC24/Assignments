package com.cars24.csms.Services;

import com.cars24.csms.data.req.LoginRequest;
import com.cars24.csms.data.req.SignupRequest;
import com.cars24.csms.data.res.ApiResponse;
import com.cars24.csms.data.res.LoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AppUserService {
    ResponseEntity<ApiResponse> signUp(SignupRequest signupRequest);
    LoginResponse getAppUserDetails(LoginRequest loginRequest);
}
