package com.cars24.csms.Services.Impl;

import lombok.RequiredArgsConstructor;
import com.cars24.csms.data.Dao.Impl.AppUserDaoImpl;
import com.cars24.csms.Services.AppUserService;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import com.cars24.csms.data.req.LoginRequest;
import com.cars24.csms.data.repositories.AppUserRepository;
import com.cars24.csms.data.req.SignupRequest;
import com.cars24.csms.Exceptions.UserServiceException;
import com.cars24.csms.data.res.ApiResponse;
import com.cars24.csms.data.entities.AppUserDetailsEntity;
import com.cars24.csms.data.res.LoginResponse;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Service
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository appUserRepository;
    private final AppUserDaoImpl appUserDaoImpl;
    @Override
    public LoginResponse getAppUserDetails(LoginRequest loginRequest) {
        AppUserDetailsEntity appUserDetails = appUserDaoImpl.getAppUser(loginRequest);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setId(appUserDetails.getId());
        loginResponse.setUsername(appUserDetails.getUsername());
        return loginResponse;
    }
    @Override
    public ResponseEntity<ApiResponse> signUp(SignupRequest signupRequest) {
        ApiResponse apiResponse = new ApiResponse();
        if(appUserRepository.existsByUsername(signupRequest.getUsername())){
            throw new UserServiceException("User exists!!");
        }
        appUserDaoImpl.signUp(signupRequest);
        apiResponse.setStatusCode(HttpStatus.OK.value());
        apiResponse.setSuccess(true);
        apiResponse.setMessage("User signed up!!");
        apiResponse.setData(null);
        apiResponse.setService("APP_USER - " + HttpStatus.OK.value());
        return ResponseEntity.ok().body(apiResponse);
    }
}
