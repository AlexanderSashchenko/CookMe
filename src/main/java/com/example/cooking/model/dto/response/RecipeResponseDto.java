package com.example.cooking.model.dto.response;

import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public class RecipeResponseDto {
    private long id;
    private String name;
    private String description;
    //TODO: File photo
    private List<Long> dishTypeIds;
    private List<Long> mealTimeIds;
    private Map<Long, Long> ingredients;
    private List<Long> portionIds;
    private int preparationTime;
}
