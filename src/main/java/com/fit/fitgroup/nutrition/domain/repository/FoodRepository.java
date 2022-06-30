package com.fit.fitgroup.nutrition.domain.repository;

import com.fit.fitgroup.nutrition.mapping.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> {
    Optional<Food> findByName(String name);
}
