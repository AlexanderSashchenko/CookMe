package com.example.cooking.service.impl;

import com.example.cooking.model.Profile;
import com.example.cooking.repository.ProfileRepository;
import com.example.cooking.service.ProfileService;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile add(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile get(Long id) {
        return profileRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Profile was not found!"));
    }

    @Override
    public Profile update(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public void delete(Profile profile) {
        profileRepository.delete(profile);
    }
}
