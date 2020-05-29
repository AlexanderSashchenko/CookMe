package com.example.cooking.repository;

import com.example.cooking.model.MealCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealCategoryRepository extends JpaRepository<MealCategory, Long> {
}
