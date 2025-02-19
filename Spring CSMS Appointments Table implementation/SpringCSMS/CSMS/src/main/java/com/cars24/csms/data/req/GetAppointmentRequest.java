package com.cars24.csms.data.req;

import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Valid
@Data
public class GetAppointmentRequest {
    private int appointment_id;
    private int customer_id;
    private int service_id;
    private int vehicle_id;
    private String status;
    private String appointment_date;

}
