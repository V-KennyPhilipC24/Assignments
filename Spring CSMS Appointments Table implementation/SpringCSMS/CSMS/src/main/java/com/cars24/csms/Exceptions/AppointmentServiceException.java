package com.cars24.csms.Exceptions;

public class AppointmentServiceException extends RuntimeException {
    public AppointmentServiceException(String message) {
        super(message);
    }
}
