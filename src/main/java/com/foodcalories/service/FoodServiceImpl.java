package com.foodcalories.service;

import com.foodcalories.entity.Food;
import com.foodcalories.exception.ResourceNotFoundException;
import com.foodcalories.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;

    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public Food createFood(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public Food updateFood(Long id, Food updatedFood) {
        Food existing = foodRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Food not found with id: " + id));

        existing.setName(updatedFood.getName());
        existing.setCategory(updatedFood.getCategory());
        existing.setCalories(updatedFood.getCalories());
        existing.setProtein(updatedFood.getProtein());
        existing.setCarbs(updatedFood.getCarbs());
        existing.setFats(updatedFood.getFats());

        return foodRepository.save(existing);
    }

    @Override
    public void deleteFood(Long id) {
        Food existing = foodRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Food not found with id: " + id));

        foodRepository.delete(existing);
    }

    @Override
    public Food getFoodById(Long id) {
        return foodRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Food not found with id: " + id));
    }

    @Override
    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    @Override
    public List<Food> getFoodsByCategory(String category) {
        return foodRepository.findByCategoryIgnoreCase(category);
    }

    @Override
    public List<Food> searchByName(String name) {
        return foodRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Food> searchByCalorieRange(Integer min, Integer max) {
        if (min == null) min = 0;
        if (max == null) max = Integer.MAX_VALUE;
        return foodRepository.findByCaloriesBetween(min, max);
    }
}
