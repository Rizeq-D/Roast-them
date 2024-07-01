package com.example.roastem

sealed class Screen(val route:String) {

    object ScreenRecipe:Screen("recipescreen")
    object DetailScreen:Screen("detailscreen")

}