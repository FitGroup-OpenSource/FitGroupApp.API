package com.fit.fitgroup.nutrition.service;

import com.fit.fitgroup.nutrition.domain.model.model.Food;
import com.fit.fitgroup.nutrition.domain.repository.FoodRepository;
import com.fit.fitgroup.nutrition.domain.service.FoodService;
import com.fit.fitgroup.shared.exception.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    private static final String ENTITY = "Food";
    @Autowired
    private FoodRepository foodRepository;
    
    @Override
    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    @Override
    public Food getFoodById(Long foodId) {
        return foodRepository.findById(foodId)
                .orElseThrow(()-> new ResourceNotFoundException("Food","Id",foodId));
    }

    @Override
    public ResponseEntity<?> deleteFood(Long foodId) {
        Food food = foodRepository.findById(foodId)
                .orElseThrow(() -> new ResourceNotFoundException("Food", "Id", foodId));
        foodRepository.delete(food);
        return ResponseEntity.ok().build();
    }
}
