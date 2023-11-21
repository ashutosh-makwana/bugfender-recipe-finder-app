package com.bugfender.recipefinderapp

object FakeDatabase {
    // Sample list of recipes
    private val recipes = listOf(
        Recipe(1, "Tomato Basil Pasta", listOf("Pasta", "Tomato", "Basil"), "image_url_1"),
        Recipe(2, "Grilled Cheese Sandwich", listOf("Bread", "Cheese", "Butter"), "image_url_2"),
        // Add more recipes as needed for testing
    )

    // Function to mimic data fetching
    fun getAllRecipes(): List<Recipe> {
        // This function simulates fetching recipes from a remote server
        return recipes
    }
}