package com.one993.notescleanarchitecture.data.repository

import com.one993.notescleanarchitecture.data.datasource.api.MealCategoryService
import com.one993.notescleanarchitecture.domain.model.meal_category.MealCategoryResponse
import com.one993.notescleanarchitecture.domain.repository.MealCategoryRepository
import retrofit2.Response

class MealCategoryRepositoryImpl constructor(private val mealCategoryService: MealCategoryService) :
    MealCategoryRepository {

    override suspend fun getMealCategory(): Response<MealCategoryResponse> = mealCategoryService.getMealCategory()

}