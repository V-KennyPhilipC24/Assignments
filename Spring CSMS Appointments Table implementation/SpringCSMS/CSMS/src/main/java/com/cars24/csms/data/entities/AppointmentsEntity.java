package com.cars24.csms.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Where;

@Data
@Table(name = "appointments")
@Entity
@Where(clause = "is_deleted = false") // to get the records which are not deleted
public class AppointmentsEntity {
    @Id
    @Column(name = "appointment_id")
    private int appointmentId;
    @Column(name = "customer_id", nullable = false)
    private int customerId;
    @Column(name = "vehicle_id", nullable = false)
    private int vehicleId;
    @Column(name = "service_id", nullable = false)
    private int serviceId;
    @Column(name = "appointment_date", nullable = false)
    private String appointmentDate;
    @Column(nullable = false)
    private String status;
    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;
}
