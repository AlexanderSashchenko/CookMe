package com.example.cooking.service;

import com.example.cooking.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
