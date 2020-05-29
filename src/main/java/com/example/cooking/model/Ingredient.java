package com.example.cooking.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ingredients")
@Data
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
