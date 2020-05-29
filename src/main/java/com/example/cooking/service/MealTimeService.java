package com.example.cooking.service;

import com.example.cooking.model.MealTime;

public interface MealTimeService {
    MealTime add(MealTime mealTime);

    MealTime get(Long id);

    MealTime update(MealTime mealTime);

    void delete(MealTime mealTime);
}
