package com.example.cooking.service.impl;

import com.example.cooking.model.Recipe;
import com.example.cooking.repository.RecipeRepository;
import com.example.cooking.service.RecipeService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Recipe add(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe get(Long id) {
        return recipeRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Recipe was not found!"));
    }

    @Override
    public Recipe update(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public List<Recipe> getAll() {
        return recipeRepository.findAll();
    }

    @Override
    public void delete(Recipe recipe) {
        recipeRepository.delete(recipe);
    }
}
