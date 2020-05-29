package com.example.cooking.service;

import com.example.cooking.model.DailyMenu;

public interface DailyMenuService {
    DailyMenu add(DailyMenu dailyMenu);

    DailyMenu get(Long id);

    DailyMenu update(DailyMenu dailyMenu);

    void delete(DailyMenu dailyMenu);
}
