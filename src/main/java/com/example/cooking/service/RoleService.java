package com.example.cooking.service;

import com.example.cooking.model.Role;

public interface RoleService {
    Role add(Role role);

    Role getByName(String roleName);
}
