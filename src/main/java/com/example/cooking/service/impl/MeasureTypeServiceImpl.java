package com.example.cooking.service.impl;

import com.example.cooking.model.MeasureType;
import com.example.cooking.repository.MeasureTypeRepository;
import com.example.cooking.service.MeasureTypeService;
import org.springframework.stereotype.Service;

@Service
public class MeasureTypeServiceImpl implements MeasureTypeService {
    private final MeasureTypeRepository measureTypeRepository;

    public MeasureTypeServiceImpl(MeasureTypeRepository measureTypeRepository) {
        this.measureTypeRepository = measureTypeRepository;
    }

    @Override
    public MeasureType add(MeasureType measureType) {
        return measureTypeRepository.save(measureType);
    }

    @Override
    public MeasureType get(Long id) {
        return measureTypeRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Measure type was not found!"));
    }

    @Override
    public MeasureType update(MeasureType measureType) {
        return measureTypeRepository.save(measureType);
    }

    @Override
    public void delete(MeasureType measureType) {
        measureTypeRepository.delete(measureType);
    }
}
