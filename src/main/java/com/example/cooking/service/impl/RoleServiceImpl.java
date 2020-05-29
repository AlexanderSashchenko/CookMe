package com.example.cooking.service.impl;

import com.example.cooking.model.Role;
import com.example.cooking.repository.RoleRepository;
import com.example.cooking.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role add(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getByName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
