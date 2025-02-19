package com.cars24.csms.data.Dao.Impl;

import com.cars24.csms.Exceptions.UserServiceException;
import com.cars24.csms.data.Dao.AppointmentDao;
import com.cars24.csms.data.entities.AppointmentsEntity;
import com.cars24.csms.data.enums.AppointmentStatus;
import com.cars24.csms.data.repositories.AppointmentRepository;
import com.cars24.csms.data.req.CreateAppointmentRequest;
import com.cars24.csms.data.req.GetAppointmentRequest;
import com.cars24.csms.data.res.GetAppointmentResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class AppointmentDaoImpl implements AppointmentDao {

    private final AppointmentRepository appointmentRepository;
    @Override
    public int createAppointment(CreateAppointmentRequest createAppointmentRequest) {
        AppointmentsEntity appointmentsEntity = new AppointmentsEntity();
        appointmentsEntity.setCustomerId(createAppointmentRequest.getCustomer_id());
        appointmentsEntity.setStatus(createAppointmentRequest.getStatus().toString());
        appointmentsEntity.setVehicleId(createAppointmentRequest.getVehicle_id());
        appointmentsEntity.setAppointmentDate(createAppointmentRequest.getAppointment_date());
        appointmentsEntity.setServiceId(createAppointmentRequest.getService_id());
        appointmentRepository.save(appointmentsEntity);
        return 0;
    }
    @Override
    public AppointmentsEntity getAppointments(Integer appointments_id) {
        AppointmentsEntity appointmentsEntity = appointmentRepository.findById(appointments_id) .orElseThrow(()->new RuntimeException("Appointments not found with id: "+appointments_id));

        /*
        need to implement as an api response message on postman: else everything works
         */
        if (appointmentsEntity.isDeleted()) {
            throw new UserServiceException("Sorry!! Appointment Id doesn't exist anymore");
        }

        GetAppointmentResponse getAppointmentResponse = new GetAppointmentResponse();
        getAppointmentResponse.setCustomerId(appointmentsEntity.getCustomerId());
        getAppointmentResponse.setServiceId(appointmentsEntity.getServiceId());
        getAppointmentResponse.setVehicleId(appointmentsEntity.getVehicleId());
        getAppointmentResponse.setStatus(AppointmentStatus.valueOf(appointmentsEntity.getStatus()));
        getAppointmentResponse.setAppointmentDate(appointmentsEntity.getAppointmentDate());
        log.info("[getCustomer] in DAO, retrieved record: {}",getAppointmentResponse);
//        return appointmentRepository.findAllByStatus(getAppointmentRequest.getStatus());
        return appointmentsEntity;
    }


    @Transactional
    @Override
    public void deleteAppointments(int appointmentId) {
        int updatedRows = appointmentRepository.deleteAppointments(appointmentId);
        if (updatedRows == 0) {
            throw new RuntimeException("No appointment found with id: " + appointmentId);
        }
    }
}