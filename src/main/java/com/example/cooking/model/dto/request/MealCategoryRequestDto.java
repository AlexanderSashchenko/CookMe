package com.example.cooking.model.dto.request;

import lombok.Data;

@Data
public class MealCategoryRequestDto {
    private String name;
    private String description;
    private String mealCategoryGroupCoverageCoefficient;
}
