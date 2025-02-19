package com.cars24.csms.data.res;

import com.cars24.csms.data.enums.AppointmentStatus;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
@Valid
public class GetAppointmentResponse {
    private int customerId;
    private int vehicleId;
    private int serviceId;
    private AppointmentStatus status;
    private String appointmentDate;

}
