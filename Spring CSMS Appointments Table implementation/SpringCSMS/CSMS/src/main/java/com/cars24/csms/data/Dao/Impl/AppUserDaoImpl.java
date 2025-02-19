package com.cars24.csms.data.Dao.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.cars24.csms.data.Dao.AppUserDao;
import com.cars24.csms.data.req.LoginRequest;
import com.cars24.csms.data.repositories.AppUserRepository;
import com.cars24.csms.data.req.SignupRequest;
import com.cars24.csms.data.entities.AppUserDetailsEntity;
import com.fasterxml.jackson.databind.ObjectMapper;


@RequiredArgsConstructor
@Slf4j
@Service
public class AppUserDaoImpl implements AppUserDao {

    final private AppUserRepository appUserRepository;

    @Override
    public AppUserDetailsEntity getAppUser(LoginRequest loginRequest) {
        return appUserRepository.findAppUserDetailsByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
    }
    @Override
    public void signUp(SignupRequest signupRequest) {
        AppUserDetailsEntity appUserDetails;
        ObjectMapper mapper = new ObjectMapper();
        appUserDetails = mapper.convertValue(signupRequest, AppUserDetailsEntity.class);
        appUserDetails.set_enabled(true);
        appUserRepository.save(appUserDetails);
    }
}
