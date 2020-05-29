package com.example.cooking.model.dto.request;

import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserRegistrationDto {
    @NotEmpty(message = "Entered value must not be empty")
    //TODO: add email validator annotation
    private String email;
    @NotEmpty(message = "Entered value must not be empty")
    private String password;
    @NotEmpty(message = "Entered value must not be empty")
    private String repeatPassword;
}
