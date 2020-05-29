package com.example.cooking.model.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class IngredientQuantityRequestDto {
    @NotNull
    @Min(value = 0)
    private int quantity;
}
