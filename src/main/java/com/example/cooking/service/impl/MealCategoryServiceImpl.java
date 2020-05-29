package com.example.cooking.service.impl;

import com.example.cooking.model.MealCategory;
import com.example.cooking.repository.MealCategoryRepository;
import com.example.cooking.service.MealCategoryService;
import org.springframework.stereotype.Service;

@Service
public class MealCategoryServiceImpl implements MealCategoryService {
    private final MealCategoryRepository mealCategoryRepository;

    public MealCategoryServiceImpl(MealCategoryRepository mealCategoryRepository) {
        this.mealCategoryRepository = mealCategoryRepository;
    }

    @Override
    public MealCategory add(MealCategory mealCategory) {
        return mealCategoryRepository.save(mealCategory);
    }

    @Override
    public MealCategory get(Long id) {
        return mealCategoryRepository.getOne(id);
    }

    @Override
    public MealCategory update(MealCategory mealCategory) {
        return mealCategoryRepository.save(mealCategory);
    }

    @Override
    public void delete(MealCategory mealCategory) {
        mealCategoryRepository.delete(mealCategory);
    }
}
