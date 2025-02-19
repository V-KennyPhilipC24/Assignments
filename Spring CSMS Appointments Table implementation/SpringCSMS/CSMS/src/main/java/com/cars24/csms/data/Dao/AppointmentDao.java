package com.cars24.csms.data.Dao;

import com.cars24.csms.data.entities.AppointmentsEntity;
import com.cars24.csms.data.req.CreateAppointmentRequest;
import com.cars24.csms.data.req.GetAppointmentRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppointmentDao {
    int createAppointment(CreateAppointmentRequest createAppointmentRequest);
    AppointmentsEntity getAppointments(Integer appointments_id);
    void deleteAppointments(int appointmentId);
}
