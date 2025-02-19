package com.cars24.csms.data.Dao;

import com.cars24.csms.data.entities.AppUserDetailsEntity;
import com.cars24.csms.data.req.LoginRequest;
import com.cars24.csms.data.req.SignupRequest;
import org.springframework.stereotype.Service;

@Service
public interface AppUserDao {

    AppUserDetailsEntity getAppUser(LoginRequest loginRequest);
    void signUp(SignupRequest signupRequest);
}
