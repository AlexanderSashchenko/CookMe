package com.example.cooking.service;

import com.example.cooking.model.DishType;

public interface DishTypeService {
    DishType add(DishType dishType);

    DishType get(Long id);

    DishType update(DishType dishType);

    void delete(DishType dishType);
}
