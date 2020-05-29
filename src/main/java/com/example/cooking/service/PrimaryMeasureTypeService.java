package com.example.cooking.service;

import com.example.cooking.model.PrimaryMeasureType;

public interface PrimaryMeasureTypeService {
    PrimaryMeasureType add(PrimaryMeasureType primaryMeasureType);

    PrimaryMeasureType get(Long id);

    PrimaryMeasureType update(PrimaryMeasureType primaryMeasureType);

    void delete(PrimaryMeasureType primaryMeasureType);
}
