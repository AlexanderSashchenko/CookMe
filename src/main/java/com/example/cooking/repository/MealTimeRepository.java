package com.example.cooking.repository;

import com.example.cooking.model.MealTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealTimeRepository extends JpaRepository<MealTime, Long> {
}
