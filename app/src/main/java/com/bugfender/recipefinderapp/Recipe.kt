package com.bugfender.recipefinderapp

data class Recipe(val id: Int, val title: String, val ingredients: List<String>, val imageUrl: String)

// The Recipe data class has four parameters:
// id (Int): A unique identifier for the recipe.
// title (String): The name of the recipe.
// ingredients (List<String>): A list of ingredients required for the recipe.
// imageUrl (String): A URL to an image of the finished dish.