package com.example.cooking.model.dto.request;

import lombok.Data;

@Data
public class UserAuthenticationDto {
    private String username;
    private String password;

}
