package com.example.cooking.model.dto.response;

import java.util.Set;
import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;
    private String name;
    private String login;
    private String email;
    private Set<Long> roleIds;
}
