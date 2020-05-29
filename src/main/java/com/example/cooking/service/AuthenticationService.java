package com.example.cooking.service;

import com.example.cooking.model.User;

public interface AuthenticationService {
    /*User login(String email, String password) throws AuthenticationException;*/

    User register(String email, String password);
}
