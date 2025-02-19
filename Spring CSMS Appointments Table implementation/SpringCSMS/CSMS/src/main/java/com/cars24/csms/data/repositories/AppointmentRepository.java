package com.cars24.csms.data.repositories;

import com.cars24.csms.data.entities.AppointmentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentsEntity, Integer> {
    @Modifying
    @Query("UPDATE AppointmentsEntity a SET a.isDeleted = true WHERE a.appointmentId = :appointmentId")
    int deleteAppointments(@Param("appointmentId") int appointmentId);
    boolean existsByCustomerIdAndServiceIdAndVehicleId(int serviceId, int vehicleId, int customerId);
    List<AppointmentsEntity> findAllByStatus(String status);
}
