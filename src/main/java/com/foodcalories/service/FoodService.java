package com.foodcalories.service;

import com.foodcalories.entity.Food;

import java.util.List;

public interface FoodService {

    Food createFood(Food food);

    Food updateFood(Long id, Food food);

    void deleteFood(Long id);

    Food getFoodById(Long id);

    List<Food> getAllFoods();

    List<Food> getFoodsByCategory(String category);

    List<Food> searchByName(String name);

    List<Food> searchByCalorieRange(Integer min, Integer max);
}
