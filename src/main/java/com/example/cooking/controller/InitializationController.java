package com.example.cooking.controller;

import com.example.cooking.model.Role;
import com.example.cooking.model.User;
import com.example.cooking.service.RoleService;
import com.example.cooking.service.UserService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitializationController {
    private final RoleService roleService;
    private final UserService userService;

    public InitializationController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/inject")
    public String injectData() {
        Role userRole = new Role();
        userRole.setRoleName("USER");
        roleService.add(userRole);
        Role adminRole = new Role();
        adminRole.setRoleName("ADMIN");
        roleService.add(adminRole);

        User user = new User();
        user.setEmail("user@test.com");
        user.setPassword("user");
        Set<Role> roles = new HashSet<>();
        roles.add(userRole);
        user.setRoles(roles);
        userService.add(user);

        User admin = new User();
        admin.setEmail("admin@test.com");
        admin.setPassword("admin");
        roles.clear();
        roles.add(adminRole);
        admin.setRoles(roles);
        userService.add(admin);

        return "Users and roles are added";
    }
}
