package com.one993.notescleanarchitecture.domain.repository

import com.one993.notescleanarchitecture.domain.model.meal_category.MealCategoryResponse
import retrofit2.Response

interface MealCategoryRepository {
    suspend fun getMealCategory() : Response<MealCategoryResponse>
}