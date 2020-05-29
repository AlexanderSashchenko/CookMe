package com.example.cooking.service.impl;

import com.example.cooking.model.Profile;
import com.example.cooking.model.Role;
import com.example.cooking.model.User;
import com.example.cooking.repository.RoleRepository;
import com.example.cooking.repository.UserRepository;
import com.example.cooking.service.AuthenticationService;
import com.example.cooking.service.ProfileService;
import com.example.cooking.service.UserService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ProfileService profileService;

    public AuthenticationServiceImpl(UserService userService,
                                     PasswordEncoder passwordEncoder,
                                     UserRepository userRepository,
                                     RoleRepository roleRepository,
                                     ProfileService profileService) {
        this.userService = userService;
        this.profileService = profileService;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    /*Using embedded authentication for now
    @Override
    public User login(String email, String password) throws AuthenticationException {
        User user = userService.getByEmail(email);
        if (user.getPassword().equals(passwordEncoder.encode(password))) {
            return user;
        }
        throw new AuthenticationException("Incorrect login or password!");
    }*/

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByRoleName("USER"));
        user.setRoles(roles);
        User savedUser = userRepository.save(user);
        Profile profile = new Profile();
        profile.setUser(savedUser);
        profileService.add(profile);
        return savedUser;
    }
}
