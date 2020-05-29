package com.example.cooking.service;

import com.example.cooking.model.MealCategoryGroup;

public interface MealCategoryGroupService {
    MealCategoryGroup add(MealCategoryGroup mealCategoryGroup);

    MealCategoryGroup get(Long id);

    MealCategoryGroup update(MealCategoryGroup mealCategoryGroup);

    void delete(MealCategoryGroup mealCategoryGroup);
}
