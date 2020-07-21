package com.example.cooking.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserAuthenticationResponseDto {
    private String jwt;
}
