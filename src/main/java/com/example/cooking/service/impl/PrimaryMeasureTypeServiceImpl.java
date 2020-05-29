package com.example.cooking.service.impl;

import com.example.cooking.model.PrimaryMeasureType;
import com.example.cooking.repository.PrimaryMeasureTypeRepository;
import com.example.cooking.service.PrimaryMeasureTypeService;
import org.springframework.stereotype.Service;

@Service
public class PrimaryMeasureTypeServiceImpl implements PrimaryMeasureTypeService {
    private final PrimaryMeasureTypeRepository primaryMeasureTypeRepository;

    public PrimaryMeasureTypeServiceImpl(
            PrimaryMeasureTypeRepository primaryMeasureTypeRepository) {
        this.primaryMeasureTypeRepository = primaryMeasureTypeRepository;
    }

    @Override
    public PrimaryMeasureType add(PrimaryMeasureType primaryMeasureType) {
        return primaryMeasureTypeRepository.save(primaryMeasureType);
    }

    @Override
    public PrimaryMeasureType get(Long id) {
        return primaryMeasureTypeRepository.getOne(id);
    }

    @Override
    public PrimaryMeasureType update(PrimaryMeasureType primaryMeasureType) {
        return primaryMeasureTypeRepository.save(primaryMeasureType);
    }

    @Override
    public void delete(PrimaryMeasureType primaryMeasureType) {
        primaryMeasureTypeRepository.delete(primaryMeasureType);
    }
}
