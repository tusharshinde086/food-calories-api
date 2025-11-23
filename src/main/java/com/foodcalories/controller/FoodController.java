package com.foodcalories.controller;

import com.foodcalories.entity.Food;
import com.foodcalories.service.FoodService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
@CrossOrigin(origins = "*")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    // POST /api/foods - Add new food item
    @PostMapping
    public Food createFood(@Valid @RequestBody Food food) {
        return foodService.createFood(food);
    }

    // GET /api/foods - Get all food items
    @GetMapping
    public List<Food> getAllFoods() {
        return foodService.getAllFoods();
    }

    // GET /api/foods/{id} - Get food by ID
    @GetMapping("/{id}")
    public Food getFoodById(@PathVariable Long id) {
        return foodService.getFoodById(id);
    }

    // PUT /api/foods/{id} - Update food
    @PutMapping("/{id}")
    public Food updateFood(@PathVariable Long id,
                           @Valid @RequestBody Food food) {
        return foodService.updateFood(id, food);
    }

    // DELETE /api/foods/{id} - Delete food
    @DeleteMapping("/{id}")
    public void deleteFood(@PathVariable Long id) {
        foodService.deleteFood(id);
    }

    // GET /api/foods/category/{category} - Search by category
    @GetMapping("/category/{category}")
    public List<Food> getByCategory(@PathVariable String category) {
        return foodService.getFoodsByCategory(category);
    }

    // GET /api/foods/search?name=x - Search by name
    @GetMapping("/search")
    public List<Food> searchByName(@RequestParam String name) {
        return foodService.searchByName(name);
    }

    // GET /api/foods/calories?min=100&max=300 - Calorie range filter
    @GetMapping("/calories")
    public List<Food> searchByCalories(@RequestParam(required = false) Integer min,
                                       @RequestParam(required = false) Integer max) {
        return foodService.searchByCalorieRange(min, max);
    }
}
