package com.example.cooking.model.dto.request;

import java.util.List;
import java.util.Map;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class RecipeRequestDto {
    @NotNull
    @Size(min = 1, max = 199)
    private String name;
    private String description;
    //TODO: File photo
    @NotEmpty
    private List<Long> dishTypeIds;
    @NotEmpty
    private List<Long> mealTimeIds;
    @NotEmpty
    private Map<Long, Long> ingredients;
    @NotEmpty
    private List<Long> portionIds;
    @NotNull
    @Positive
    private int preparationTime;
}
