package com.example.cooking.service;

import com.example.cooking.model.Profile;

public interface ProfileService {
    Profile add(Profile profile);

    Profile get(Long id);

    Profile update(Profile profile);

    void delete(Profile profile);
}
