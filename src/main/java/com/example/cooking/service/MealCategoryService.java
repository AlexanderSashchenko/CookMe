package com.example.cooking.service;

import com.example.cooking.model.MealCategory;

public interface MealCategoryService {
    MealCategory add(MealCategory mealCategory);

    MealCategory get(Long id);

    MealCategory update(MealCategory mealCategory);

    void delete(MealCategory mealCategory);
}
