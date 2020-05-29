package com.example.cooking.repository;

import com.example.cooking.model.DishType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishTypeRepository extends JpaRepository<DishType, Long> {
}
