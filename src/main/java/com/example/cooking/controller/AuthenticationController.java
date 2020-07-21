package com.example.cooking.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.cooking.model.Role;
import com.example.cooking.model.User;
import com.example.cooking.model.dto.request.UserAuthenticationDto;
import com.example.cooking.model.dto.request.UserRegistrationDto;
import com.example.cooking.model.dto.response.UserAuthenticationResponseDto;
import com.example.cooking.model.dto.response.UserResponseDto;
import com.example.cooking.security.JwtProperties;
import com.example.cooking.service.AuthenticationService;
import java.util.Date;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    public AuthenticationController(AuthenticationService authenticationService,
                                    AuthenticationManager authenticationManager,
                                    UserDetailsService userDetailsService) {
        this.authenticationService = authenticationService;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/authentication")
    public ResponseEntity<?> login(@RequestBody @Valid UserAuthenticationDto authenticationDto) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationDto.getUsername(), authenticationDto.getPassword()));
        } catch (BadCredentialsException exception) {
            throw new RuntimeException("Incorrect username or password!", exception);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(
                authenticationDto.getUsername());
        final String jwt = JWT.create()
                .withSubject(userDetails.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()
                        + JwtProperties.EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(JwtProperties.SECRET.getBytes()));

        return ResponseEntity.ok(new UserAuthenticationResponseDto(jwt));
    }

    @PostMapping("/registration")
    public UserResponseDto register(@RequestBody @Valid UserRegistrationDto userRegistrationDto) {
        User user = authenticationService.register(userRegistrationDto.getEmail(),
                userRegistrationDto.getPassword());
        return mapUserToUserResponseDto(user);
    }

    private UserResponseDto mapUserToUserResponseDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setName(user.getName());
        userResponseDto.setLogin(user.getLogin());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setRoleIds(user.getRoles().stream()
                .map(Role::getId)
                .collect(Collectors.toSet()));
        return userResponseDto;
    }
}
