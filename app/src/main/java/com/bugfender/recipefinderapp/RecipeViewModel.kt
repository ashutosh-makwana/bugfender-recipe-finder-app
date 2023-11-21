package com.bugfender.recipefinderapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class RecipeViewModel : ViewModel() {
    val recipes: LiveData<Result<List<Recipe>>> = liveData(Dispatchers.IO) {
        emit(Result.Loading) // Indicate loading state
        try {
            // Simulate network delay and fetch data
            val fetchedRecipes = withContext(Dispatchers.IO) {
                delay(2000) // Simulate network delay
                FakeDatabase.getAllRecipes() // Fetch recipes
            }
            emit(Result.Success(fetchedRecipes)) // Emit successful data fetch
        } catch (e: Exception) {
            // Emit a detailed error state
            emit(Result.Error(Exception("Error fetching recipes: ${e.localizedMessage}")))
        }
    }
}

