package com.example.cooking.service;

import com.example.cooking.model.Portion;

public interface PortionService {
    Portion add(Portion portion);

    Portion get(Long id);

    Portion update(Portion portion);

    void delete(Portion portion);
}
