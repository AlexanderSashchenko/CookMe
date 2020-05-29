package com.example.cooking.service.impl;

import com.example.cooking.model.Portion;
import com.example.cooking.repository.PortionRepository;
import com.example.cooking.service.PortionService;
import org.springframework.stereotype.Service;

@Service
public class PortionServiceImpl implements PortionService {
    private final PortionRepository portionRepository;

    public PortionServiceImpl(PortionRepository portionRepository) {
        this.portionRepository = portionRepository;
    }

    @Override
    public Portion add(Portion portion) {
        return portionRepository.save(portion);
    }

    @Override
    public Portion get(Long id) {
        return portionRepository.findById(id).orElse(new Portion());
    }

    @Override
    public Portion update(Portion portion) {
        return portionRepository.save(portion);
    }

    @Override
    public void delete(Portion portion) {
        portionRepository.delete(portion);
    }
}
