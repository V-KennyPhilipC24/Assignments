package com.cars24.csms.Controller;

import com.cars24.csms.Services.Impl.AppointmentServiceImpl;
import com.cars24.csms.data.entities.AppointmentsEntity;
import com.cars24.csms.data.enums.AppointmentStatus;
import com.cars24.csms.data.repositories.AppointmentRepository;
import com.cars24.csms.data.req.CreateAppointmentRequest;
import com.cars24.csms.data.req.GetAppointmentRequest;
import com.cars24.csms.data.res.ApiResponse;
import com.cars24.csms.data.res.CreateAppointmentResponse;
import com.cars24.csms.data.res.GetAppointmentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Slf4j
@Valid
@RestController
@RequiredArgsConstructor
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentServiceImpl appointmentServiceImpl;
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createAppointment(@Valid @RequestBody CreateAppointmentRequest createAppointmentRequest){
        log.info("[createAppointment] createAppointmentRequest {}", createAppointmentRequest);
        CreateAppointmentResponse createAppointmentResponse = new CreateAppointmentResponse();
        return appointmentServiceImpl.CreateAppointmentResponse(createAppointmentRequest);
    }

    @GetMapping("/getProfile/{appointments_id}")
    public ResponseEntity<AppointmentsEntity> getAppointments(@Valid @PathVariable Integer appointments_id)
    {
        GetAppointmentResponse getAppointmentResponse=new GetAppointmentResponse();
        log.info("[In get controller] getAppointmentsRequest{}",appointments_id);
        AppointmentsEntity appointmentsEntity = appointmentServiceImpl.getAppointments(appointments_id);
        return ResponseEntity.ok().body(appointmentsEntity);
    }

    @DeleteMapping("/delete/{appointmentId}")
    public ResponseEntity<ApiResponse> deleteAppointment(@PathVariable int appointmentId) {
        log.info("[deleteAppointment] appointmentId: {}", appointmentId);
        return appointmentServiceImpl.deleteAppointment(appointmentId);
    }
}