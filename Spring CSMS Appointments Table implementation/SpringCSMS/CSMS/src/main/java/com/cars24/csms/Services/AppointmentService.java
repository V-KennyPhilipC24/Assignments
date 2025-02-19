package com.cars24.csms.Services;

import com.cars24.csms.data.req.CreateAppointmentRequest;
import com.cars24.csms.data.res.ApiResponse;
import com.cars24.csms.data.res.CreateAppointmentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AppointmentService {
    ResponseEntity<ApiResponse> CreateAppointmentResponse(CreateAppointmentRequest createAppointmentRequest);

    ResponseEntity<ApiResponse> deleteAppointment(int appointmentId);
//
}
