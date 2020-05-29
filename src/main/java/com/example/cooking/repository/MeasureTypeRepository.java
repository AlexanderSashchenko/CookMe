package com.example.cooking.repository;

import com.example.cooking.model.MeasureType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasureTypeRepository extends JpaRepository<MeasureType, Long> {
}
