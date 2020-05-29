package com.example.cooking.service;

import com.example.cooking.model.User;

public interface UserService {
    User add(User user);

    User get(Long id);

    User update(User user);

    User getByEmail(String email);

    void delete(User user);
}
