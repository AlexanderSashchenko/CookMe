package com.example.cooking.service.impl;

import com.example.cooking.model.DishType;
import com.example.cooking.repository.DishTypeRepository;
import com.example.cooking.service.DishTypeService;
import org.springframework.stereotype.Service;

@Service
public class DishTypeServiceImpl implements DishTypeService {
    private final DishTypeRepository dishTypeRepository;

    public DishTypeServiceImpl(DishTypeRepository dishTypeRepository) {
        this.dishTypeRepository = dishTypeRepository;
    }

    @Override
    public DishType add(DishType dishType) {
        return dishTypeRepository.save(dishType);
    }

    @Override
    public DishType get(Long id) {
        return dishTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dish type was not found!"));
    }

    @Override
    public DishType update(DishType dishType) {
        return dishTypeRepository.save(dishType);
    }

    @Override
    public void delete(DishType dishType) {
        dishTypeRepository.delete(dishType);
    }
}
