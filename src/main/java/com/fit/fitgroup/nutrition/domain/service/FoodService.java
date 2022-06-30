package com.fit.fitgroup.nutrition.domain.service;

import com.fit.fitgroup.nutrition.domain.model.model.Food;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FoodService {
    List<Food> getAllFoods();
    Food getFoodById(Long foodId);
    ResponseEntity<?> deleteFood(Long foodId);
}
