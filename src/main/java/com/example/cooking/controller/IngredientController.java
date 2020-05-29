package com.example.cooking.controller;

import com.example.cooking.model.Ingredient;
import com.example.cooking.model.MeasureType;
import com.example.cooking.model.dto.request.IngredientRequestDto;
import com.example.cooking.model.dto.response.IngredientResponseDto;
import com.example.cooking.service.IngredientService;
import com.example.cooking.service.MealCategoryService;
import com.example.cooking.service.MeasureTypeService;
import com.example.cooking.service.PrimaryMeasureTypeService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/ingredients")
public class IngredientController {
    private final IngredientService ingredientService;
    private final MealCategoryService mealCategoryService;
    private final PrimaryMeasureTypeService primaryMeasureTypeService;
    private final MeasureTypeService measureTypeService;

    public IngredientController(IngredientService ingredientService,
                                MealCategoryService mealCategoryService,
                                PrimaryMeasureTypeService primaryMeasureTypeService,
                                MeasureTypeService measureTypeService) {
        this.ingredientService = ingredientService;
        this.mealCategoryService = mealCategoryService;
        this.primaryMeasureTypeService = primaryMeasureTypeService;
        this.measureTypeService = measureTypeService;
    }

    @PostMapping
    public String add(@RequestBody @Valid IngredientRequestDto ingredientRequestDto) {
        ingredientService.add(convertDtoToEntity(ingredientRequestDto));
        return "Ingredient was successfully added";
    }

    @GetMapping("/{id}")
    public IngredientResponseDto get(@PathVariable("id") Long id) {
        return convertEntityToDto(ingredientService.get(id));
    }

    @GetMapping
    public List<IngredientResponseDto> getAll() {
        return ingredientService.getAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/{id}")
    public String update(@PathVariable("id") Long id,
                             @RequestBody @Valid IngredientRequestDto ingredientRequestDto) {
        Ingredient ingredient = convertDtoToEntity(ingredientRequestDto);
        ingredient.setId(id);
        ingredientService.update(ingredient);
        return "Ingredient was successfully updated";
    }

    private Ingredient convertDtoToEntity(IngredientRequestDto ingredientRequestDto) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(ingredientRequestDto.getName());
        ingredient.setMealCategory(
                mealCategoryService.get(ingredientRequestDto.getMealCategoryId()));
        ingredient.setPrimaryMeasureType(
                primaryMeasureTypeService.get(ingredientRequestDto.getPrimaryMeasureTypeId()));
        ingredient.setMeasureTypes(ingredientRequestDto.getMeasureTypeIds()
                .stream()
                .map(measureTypeService::get)
                .collect(Collectors.toSet()));
        ingredient.setCaloriesPerHundredGrams(ingredientRequestDto.getCaloriesPerHundredGrams());
        ingredient.setProteinPerHundredGrams(ingredientRequestDto.getProteinPerHundredGrams());
        ingredient.setFatPerHundredGrams(ingredientRequestDto.getCarbohydratePerHundredGrams());
        ingredient.setCarbohydratePerHundredGrams(
                ingredientRequestDto.getCarbohydratePerHundredGrams());
        return ingredient;
    }

    private IngredientResponseDto convertEntityToDto(Ingredient ingredient) {
        IngredientResponseDto ingredientResponseDto = new IngredientResponseDto();
        ingredientResponseDto.setId(ingredient.getId());
        ingredientResponseDto.setName(ingredient.getName());
        ingredientResponseDto.setMealCategoryId(ingredient.getMealCategory().getId());
        ingredientResponseDto.setPrimaryMeasureTypeId(ingredient.getPrimaryMeasureType().getId());
        ingredientResponseDto.setMeasureTypeIds(ingredient.getMeasureTypes()
                .stream()
                .map(MeasureType::getId)
                .collect(Collectors.toList()));
        ingredientResponseDto.setCaloriesPerHundredGrams(ingredient.getCaloriesPerHundredGrams());
        ingredientResponseDto.setProteinPerHundredGrams(ingredient.getProteinPerHundredGrams());
        ingredientResponseDto.setFatPerHundredGrams(ingredient.getFatPerHundredGrams());
        ingredientResponseDto.setCarbohydratePerHundredGrams(
                ingredient.getCarbohydratePerHundredGrams());
        return ingredientResponseDto;
    }
}
