package com.example.cooking.repository;

import com.example.cooking.model.DailyMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyMenuRepository extends JpaRepository<DailyMenu, Long> {
}
