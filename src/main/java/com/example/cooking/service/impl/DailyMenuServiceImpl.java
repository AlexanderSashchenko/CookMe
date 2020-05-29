package com.example.cooking.service.impl;

import com.example.cooking.model.DailyMenu;
import com.example.cooking.repository.DailyMenuRepository;
import com.example.cooking.service.DailyMenuService;
import org.springframework.stereotype.Service;

@Service
public class DailyMenuServiceImpl implements DailyMenuService {
    private final DailyMenuRepository dailyMenuRepository;

    public DailyMenuServiceImpl(DailyMenuRepository dailyMenuRepository) {
        this.dailyMenuRepository = dailyMenuRepository;
    }

    @Override
    public DailyMenu add(DailyMenu dailyMenu) {
        return dailyMenuRepository.save(dailyMenu);
    }

    @Override
    public DailyMenu get(Long id) {
        return dailyMenuRepository.findById(id).orElse(new DailyMenu());
    }

    @Override
    public DailyMenu update(DailyMenu dailyMenu) {
        return dailyMenuRepository.save(dailyMenu);
    }

    @Override
    public void delete(DailyMenu dailyMenu) {
        dailyMenuRepository.delete(dailyMenu);
    }
}
