package com.example.roastem

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun RecipeScreen() {
    val recipeViewModel : MainViewModel = viewModel()
    val viewStat by recipeViewModel.categoriesState

    Box(modifier = Modifier.fillMaxSize()) {
        when{
            viewStat.loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

            viewStat.error != null -> {
                Text("Error occurred")
            }

            else -> {
                // I will leave it empty for a moment
            }
        }

    }
}






























