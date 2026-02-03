package com.example.RecipeManager;

import java.util.List;

public class Recipe {
    private String dishName;
    private List<String> ingredients; 
    private List<String> instructions;

    public Recipe(String dishName, List<String> ingredients, List<String> instructions) {
        this.dishName = dishName;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }
    public String getDishName() { return dishName; }
    
    @Override
    public String toString() {
        return "\n--- " + dishName.toUpperCase() + " ---\n" +
               "Ingredients: " + ingredients + "\n" +
               "Instructions: " + instructions;
    }
}
