package com.example.cooking.service;

import com.example.cooking.model.MeasureType;

public interface MeasureTypeService {
    MeasureType add(MeasureType measureType);

    MeasureType get(Long id);

    MeasureType update(MeasureType measureType);

    void delete(MeasureType measureType);
}
