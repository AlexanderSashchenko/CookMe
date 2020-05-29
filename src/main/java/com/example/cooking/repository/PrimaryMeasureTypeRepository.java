package com.example.cooking.repository;

import com.example.cooking.model.PrimaryMeasureType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryMeasureTypeRepository extends JpaRepository<PrimaryMeasureType, Long> {
}
