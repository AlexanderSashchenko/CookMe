package com.example.cooking.model.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class IngredientResponseDto {
    private long id;
    private String name;
    private long mealCategoryId;
    private long primaryMeasureTypeId;
    private List<Long> measureTypeIds;
    private int caloriesPerHundredGrams;
    private double proteinPerHundredGrams;
    private double fatPerHundredGrams;
    private double carbohydratePerHundredGrams;
}
