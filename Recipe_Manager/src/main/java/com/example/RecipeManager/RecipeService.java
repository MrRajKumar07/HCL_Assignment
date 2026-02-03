package com.example.RecipeManager;

import java.util.*;

public class RecipeService {
    private Map<String, Recipe> recipeStorage = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecipeService service = new RecipeService();
        
        System.out.println("--- Welcome to Recipe Manager ---");

        while (true) {
            System.out.print("\nEnter Dish Name (or 'exit' to quit): ");
            String name = scanner.nextLine();
            
            if (name.equalsIgnoreCase("exit")) break;

            System.out.println("Enter ingredients (comma separated):");
            String[] ingrArray = scanner.nextLine().split(",");
            List<String> ingredients = Arrays.asList(ingrArray);

            System.out.println("Enter steps (comma separated):");
            String[] stepArray = scanner.nextLine().split(",");
            List<String> instructions = Arrays.asList(stepArray);

            Recipe newRecipe = new Recipe(name, ingredients, instructions);
            service.recipeStorage.put(name.toLowerCase(), newRecipe);
            
            System.out.println("Recipe Saved!");
            System.out.println(service.recipeStorage.get(name.toLowerCase()));
        }
        scanner.close();
        System.out.println("Program Terminated.");
    }
}