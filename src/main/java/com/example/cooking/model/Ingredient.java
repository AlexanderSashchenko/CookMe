package com.example.cooking.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne
    private MealCategory mealCategory;
    @ManyToOne
    private PrimaryMeasureType primaryMeasureType;
    @ManyToMany
    private Set<MeasureType> measureTypes;
    private Integer caloriesPerHundredGrams;
    private Double proteinPerHundredGrams;
    private Double fatPerHundredGrams;
    private Double carbohydratePerHundredGrams;
}
