package com.example.cooking.model.dto.request;

import java.util.List;
import lombok.Data;

@Data
public class MealCategoryGroupRequestDto {
    private String name;
    private String description;
    private List<MealCategoryRequestDto> mealCategoryRequestDtos;
}
