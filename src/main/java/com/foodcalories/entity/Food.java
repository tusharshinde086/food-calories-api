
package com.foodcalories.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "foods")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Food name is required")
    @Column(nullable = false, length = 100)
    private String name;

    @NotBlank(message = "Category is required")
    @Column(nullable = false, length = 50)
    private String category;

    @NotNull(message = "Calories are required")
    @Min(value = 0, message = "Calories must be positive")
    @Column(nullable = false)
    private Integer calories;

    @NotNull(message = "Protein value is required")
    @Min(value = 0, message = "Protein must be positive")
    @Column(nullable = false)
    private Float protein;

    @NotNull(message = "Carbs value is required")
    @Min(value = 0, message = "Carbs must be positive")
    @Column(nullable = false)
    private Float carbs;

    @NotNull(message = "Fats value is required")
    @Min(value = 0, message = "Fats must be positive")
    @Column(nullable = false)
    private Float fats;

    public Food() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Float getProtein() {
        return protein;
    }

    public void setProtein(Float protein) {
        this.protein = protein;
    }

    public Float getCarbs() {
        return carbs;
    }

    public void setCarbs(Float carbs) {
        this.carbs = carbs;
    }

    public Float getFats() {
        return fats;
    }

    public void setFats(Float fats) {
        this.fats = fats;
    }
}
