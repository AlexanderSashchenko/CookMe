package com.example.cooking.service.impl;

import com.example.cooking.model.Ingredient;
import com.example.cooking.repository.IngredientRepository;
import com.example.cooking.service.IngredientService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient add(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public Ingredient get(Long id) {
        return ingredientRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Ingredient was not found!"));
    }

    @Override
    public Ingredient update(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public List<Ingredient> getAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public void delete(Ingredient ingredient) {
        ingredientRepository.delete(ingredient);
    }
}
