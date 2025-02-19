package com.cars24.csms.data.req;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NonNull;

@Valid
@Data
public class LoginRequest {
    @NonNull
    @Valid
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must be greater than 8 characters, having at least one Captila letter, one small case letter, one special characeter and one number"
    )
    private String password;
    @Valid
    @NonNull
    @Pattern(
            regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
            message = "Type Correct mail format"
    )
    private String username;
}
