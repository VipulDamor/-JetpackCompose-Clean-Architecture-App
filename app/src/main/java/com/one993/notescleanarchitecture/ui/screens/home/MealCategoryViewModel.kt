package com.one993.notescleanarchitecture.ui.screens.home

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.one993.notescleanarchitecture.domain.model.meal_category.CategoriesItem
import com.one993.notescleanarchitecture.domain.model.meal_category.MealCategoryResponse

abstract class MealCategoryViewModel : ViewModel(){

    val isLoading = mutableStateOf(false)
    val mealCategoryList = mutableStateListOf<CategoriesItem?>()

    abstract fun getMealCategory()
}