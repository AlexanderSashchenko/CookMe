package com.example.cooking.repository;

import com.example.cooking.model.Portion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortionRepository extends JpaRepository<Portion, Long> {
}
