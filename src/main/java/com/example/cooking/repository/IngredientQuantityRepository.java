package com.example.cooking.repository;

import com.example.cooking.model.IngredientQuantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientQuantityRepository extends JpaRepository<IngredientQuantity, Long> {
}
