package com.example.cooking.repository;

import com.example.cooking.model.MealCategoryGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealCategoryGroupRepository extends JpaRepository<MealCategoryGroup, Long> {
}
