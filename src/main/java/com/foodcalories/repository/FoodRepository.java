package com.foodcalories.repository;

import com.foodcalories.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {

    List<Food> findByCategoryIgnoreCase(String category);

    List<Food> findByNameContainingIgnoreCase(String name);

    List<Food> findByCaloriesBetween(Integer min, Integer max);
}
