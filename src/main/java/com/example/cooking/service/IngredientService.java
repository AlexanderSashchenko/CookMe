package com.example.cooking.service;

import com.example.cooking.model.Ingredient;
import java.util.List;

public interface IngredientService {
    Ingredient add(Ingredient ingredient);

    Ingredient get(Long id);

    Ingredient update(Ingredient ingredient);

    List<Ingredient> getAll();

    void delete(Ingredient ingredient);
}
