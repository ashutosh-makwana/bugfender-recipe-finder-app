package com.bugfender.recipefinderapp

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val viewModel: RecipeViewModel by viewModels()
    private lateinit var progressBar: ProgressBar
    private lateinit var recipeRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recipeRecyclerView = findViewById(R.id.recipeRecyclerView)
        progressBar = findViewById(R.id.progressBar)
        recipeRecyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.recipes.observe(this, Observer { result ->
            when (result) {
                is Result.Loading -> progressBar.visibility = View.VISIBLE
                is Result.Success -> {
                    progressBar.visibility = View.GONE
                    recipeRecyclerView.adapter = RecipeAdapter(result.data)
                }
                is Result.Error -> {
                    progressBar.visibility = View.GONE
                    // Handle the error, e.g., show a toast or a snackbar
                }
            }
        })
    }
}

