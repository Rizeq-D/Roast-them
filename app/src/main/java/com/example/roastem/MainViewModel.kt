package com.example.roastem

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _categoriesState = mutableStateOf(RecipeState())
    val categoriesState : State<RecipeState> = _categoriesState

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                val response = recipeService.getCategories()
                if (response.isSuccessful) {
                    _categoriesState.value = _categoriesState.value.copy(
                        list = response.body()?.categories ?: emptyList(),
                        loading = false,
                        error = null
                    )
                }else{
                    _categoriesState.value = _categoriesState.value.copy(
                        loading = false,
                        error = "Error fetching Categories: ${response.message()}"
                    )
                }
            }catch (e : Exception) {
                _categoriesState.value = _categoriesState.value.copy(
                    loading = false,
                    error = "Error fetching Categories ${e.message}"
                )
            }
        }
    }

    data class RecipeState (val loading : Boolean = true,
                            val list : List<Category> = emptyList(),
                            val error: String? = null
    )
}