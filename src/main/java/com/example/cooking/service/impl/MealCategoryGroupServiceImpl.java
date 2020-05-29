package com.example.cooking.service.impl;

import com.example.cooking.model.MealCategoryGroup;
import com.example.cooking.repository.MealCategoryGroupRepository;
import com.example.cooking.service.MealCategoryGroupService;
import org.springframework.stereotype.Service;

@Service
public class MealCategoryGroupServiceImpl implements MealCategoryGroupService {
    private final MealCategoryGroupRepository mealCategoryGroupRepository;

    public MealCategoryGroupServiceImpl(MealCategoryGroupRepository mealCategoryGroupRepository) {
        this.mealCategoryGroupRepository = mealCategoryGroupRepository;
    }

    @Override
    public MealCategoryGroup add(MealCategoryGroup mealCategoryGroup) {
        return mealCategoryGroupRepository.save(mealCategoryGroup);
    }

    @Override
    public MealCategoryGroup get(Long id) {
        return mealCategoryGroupRepository.getOne(id);
    }

    @Override
    public MealCategoryGroup update(MealCategoryGroup mealCategoryGroup) {
        return mealCategoryGroupRepository.save(mealCategoryGroup);
    }

    @Override
    public void delete(MealCategoryGroup mealCategoryGroup) {
        mealCategoryGroupRepository.delete(mealCategoryGroup);
    }
}
