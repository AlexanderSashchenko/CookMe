package com.example.cooking.controller;

import com.example.cooking.model.DishType;
import com.example.cooking.model.Ingredient;
import com.example.cooking.model.IngredientQuantity;
import com.example.cooking.model.MealTime;
import com.example.cooking.model.Portion;
import com.example.cooking.model.Recipe;
import com.example.cooking.model.dto.request.RecipeRequestDto;
import com.example.cooking.model.dto.response.RecipeResponseDto;
import com.example.cooking.service.DishTypeService;
import com.example.cooking.service.IngredientQuantityService;
import com.example.cooking.service.IngredientService;
import com.example.cooking.service.MealTimeService;
import com.example.cooking.service.PortionService;
import com.example.cooking.service.RecipeService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
@RequestMapping("/recipes")
public class RecipeController {
    private final RecipeService recipeService;
    private final DishTypeService dishTypeService;
    private final MealTimeService mealTimeService;
    private final IngredientService ingredientService;
    private final IngredientQuantityService ingredientQuantityService;
    private final PortionService portionService;

    public RecipeController(RecipeService recipeService,
                            DishTypeService dishTypeService,
                            MealTimeService mealTimeService,
                            IngredientService ingredientService,
                            IngredientQuantityService ingredientQuantityService,
                            PortionService portionService) {
        this.recipeService = recipeService;
        this.dishTypeService = dishTypeService;
        this.mealTimeService = mealTimeService;
        this.ingredientService = ingredientService;
        this.ingredientQuantityService = ingredientQuantityService;
        this.portionService = portionService;
    }

    @PostMapping
    public String add(@RequestBody @Valid RecipeRequestDto recipeRequestDto) {
        recipeService.add(convertDtoToEntity(recipeRequestDto));
        return "Recipe was successfully added";
    }

    @GetMapping("/{id}")
    public RecipeResponseDto get(@PathVariable("id") Long id) {
        return convertEntityToDto(recipeService.get(id));
    }

    @GetMapping
    public List<RecipeResponseDto> getAll() {
        return recipeService.getAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/{id}")
    public String update(@PathVariable("id") Long id,
                         @RequestBody @Valid RecipeRequestDto recipeRequestDto) {
        Recipe recipe = convertDtoToEntity(recipeRequestDto);
        recipe.setId(id);
        recipeService.update(recipe);
        return "Recipe was successfully updated";
    }

    private Recipe convertDtoToEntity(RecipeRequestDto recipeRequestDto) {
        Recipe recipe = new Recipe();
        recipe.setName(recipeRequestDto.getName());
        recipe.setDescription(recipeRequestDto.getDescription());
        //TODO File with photo;
        recipe.setDishTypes(recipeRequestDto.getDishTypeIds()
                .stream()
                .map(dishTypeService::get)
                .collect(Collectors.toSet()));
        recipe.setMealTimes(recipeRequestDto.getMealTimeIds()
                .stream()
                .map(mealTimeService::get)
                .collect(Collectors.toSet()));
        recipe.setIngredients(convertDtoMapToEntityMap(recipeRequestDto.getIngredients()));
        recipe.setPortions(recipeRequestDto.getPortionIds()
                .stream()
                .map(portionService::get)
                .collect(Collectors.toSet()));
        recipe.setPreparationTime(recipeRequestDto.getPreparationTime());
        return recipe;
    }

    private RecipeResponseDto convertEntityToDto(Recipe recipe) {
        RecipeResponseDto recipeResponseDto = new RecipeResponseDto();
        recipeResponseDto.setId(recipe.getId());
        recipeResponseDto.setName(recipe.getName());
        recipeResponseDto.setDescription(recipe.getDescription());
        //TODO: File with photo;
        recipeResponseDto.setDishTypeIds(recipe.getDishTypes()
                .stream()
                .map(DishType::getId)
                .collect(Collectors.toList())
        );
        recipeResponseDto.setMealTimeIds(recipe.getMealTimes()
                .stream()
                .map(MealTime::getId)
                .collect(Collectors.toList()));
        recipeResponseDto.setIngredients(convertEntitiesMapToDtoMap(recipe.getIngredients()));
        recipeResponseDto.setPortionIds(recipe.getPortions()
                .stream()
                .map(Portion::getId)
                .collect(Collectors.toList()));
        recipeResponseDto.setPreparationTime(recipe.getPreparationTime());
        return recipeResponseDto;
    }

    private Map<Ingredient, IngredientQuantity> convertDtoMapToEntityMap(Map<Long, Long> map) {
        Map<Ingredient, IngredientQuantity> entitiesMap = new HashMap<>();
        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            entitiesMap.put(ingredientService.get(entry.getKey()),
                    ingredientQuantityService.get(entry.getValue()));
        }
        return entitiesMap;
    }

    private Map<Long, Long> convertEntitiesMapToDtoMap(Map<Ingredient, IngredientQuantity> map) {
        Map<Long, Long> dtoMap = new HashMap<>();
        for (Map.Entry<Ingredient, IngredientQuantity> entry : map.entrySet()) {
            dtoMap.put(entry.getKey().getId(), entry.getValue().getId());
        }
        return dtoMap;
    }
}
