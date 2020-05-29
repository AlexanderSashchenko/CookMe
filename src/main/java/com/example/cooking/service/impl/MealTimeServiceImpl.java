package com.example.cooking.service.impl;

import com.example.cooking.model.MealTime;
import com.example.cooking.repository.MealTimeRepository;
import com.example.cooking.service.MealTimeService;
import org.springframework.stereotype.Service;

@Service
public class MealTimeServiceImpl implements MealTimeService {
    private final MealTimeRepository mealTimeRepository;

    public MealTimeServiceImpl(MealTimeRepository mealTimeRepository) {
        this.mealTimeRepository = mealTimeRepository;
    }

    @Override
    public MealTime add(MealTime mealTime) {
        return mealTimeRepository.save(mealTime);
    }

    @Override
    public MealTime get(Long id) {
        return mealTimeRepository.getOne(id);
    }

    @Override
    public MealTime update(MealTime mealTime) {
        return mealTimeRepository.save(mealTime);
    }

    @Override
    public void delete(MealTime mealTime) {
        mealTimeRepository.delete(mealTime);
    }
}
