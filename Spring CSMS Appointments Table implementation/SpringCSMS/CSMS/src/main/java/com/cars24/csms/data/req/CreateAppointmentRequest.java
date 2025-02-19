package com.cars24.csms.data.req;

import com.cars24.csms.data.enums.AppointmentStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Valid
@Data
public class CreateAppointmentRequest {
    @Valid
    @Min(value = 1, message = "customer ID Invalid")
    private int customer_id;
    @Valid
    @Min(value = 1, message = "vehicle ID Invalid")
    private int vehicle_id;
    private AppointmentStatus status;
    @Valid
    @Min(value = 1, message = "service ID Invalid")
    private int service_id;
    @Valid
    @NotBlank
    private String appointment_date;
}
