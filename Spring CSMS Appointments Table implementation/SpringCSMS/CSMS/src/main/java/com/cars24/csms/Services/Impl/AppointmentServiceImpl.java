package com.cars24.csms.Services.Impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import com.cars24.csms.data.Dao.Impl.AppointmentDaoImpl;
import com.cars24.csms.data.repositories.AppointmentRepository;
import com.cars24.csms.data.repositories.CustomerRepository;
import com.cars24.csms.data.res.ApiResponse;
import com.cars24.csms.Exceptions.UserServiceException;
import org.springframework.http.HttpStatus;
import com.cars24.csms.data.repositories.ServiceRepository;
import com.cars24.csms.data.repositories.VehicleRepository;
import com.cars24.csms.data.req.CreateAppointmentRequest;
import com.cars24.csms.data.entities.AppointmentsEntity;
import com.cars24.csms.Services.AppointmentService;

@Slf4j
@RequiredArgsConstructor
@Service
public class AppointmentServiceImpl implements AppointmentService {
    final private AppointmentDaoImpl appointmentDao;
    final private AppointmentRepository appointmentRepository;
    final private VehicleRepository vehicleRepository;
    final private CustomerRepository customerRepository;

    public AppointmentsEntity getAppointments(Integer appointments_id)
    {
        AppointmentsEntity resp= appointmentDao.getAppointments(appointments_id);
        log.info("[GetAppointmentsService]AppointmentsService{}",appointments_id);
        return resp;
    }

    final private ServiceRepository serviceRepository;
    @Override
    public ResponseEntity<ApiResponse> CreateAppointmentResponse(CreateAppointmentRequest createAppointmentRequest) {
        boolean cid = customerRepository.existsById(createAppointmentRequest.getCustomer_id());
        log.info("[CreateAppointmentResponse] cid: {}",cid);
        if(!cid){
            throw new UserServiceException("No Record present of given Customer Id");
        }
        boolean sid = serviceRepository.existsById(createAppointmentRequest.getService_id());
        log.info("[CreateAppointmentResponse] sid: {}",sid);
        if(!sid){
            throw new UserServiceException("No Record present of given Service Id");
        }
        boolean vid = vehicleRepository.existsById(createAppointmentRequest.getVehicle_id());
        log.info("[CreateAppointmentResponse] vid: {}",vid);
        if(!vid){
            throw new UserServiceException("No Record present of given Vehicle Id");
        }
        if(appointmentRepository.existsByCustomerIdAndServiceIdAndVehicleId(
                createAppointmentRequest.getService_id(),
                createAppointmentRequest.getVehicle_id(),
                createAppointmentRequest.getCustomer_id())
        ) { throw new UserServiceException("U cannot have redundant ID's for multiple rows"); }

        appointmentDao.createAppointment(createAppointmentRequest);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Added Successfully!!");
        apiResponse.setStatusCode(HttpStatus.OK.value());
        apiResponse.setData(null);
        apiResponse.setSuccess(true);
        apiResponse.setService("APP_USER = "+ HttpStatus.OK.value());
        return ResponseEntity.ok().body(apiResponse);
    }

    @Override
    public ResponseEntity<ApiResponse> deleteAppointment(int appointmentId) {
        log.info("[DeleteAppointment] appointmentId: {}", appointmentId);
        appointmentDao.deleteAppointments(appointmentId);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Deleted Successfully!!");
        apiResponse.setStatusCode(HttpStatus.OK.value());
        apiResponse.setData(null);
        apiResponse.setSuccess(true);
        apiResponse.setService("DELETE_SERVICE = " + HttpStatus.OK.value());
        return ResponseEntity.ok().body(apiResponse);
    }
}
