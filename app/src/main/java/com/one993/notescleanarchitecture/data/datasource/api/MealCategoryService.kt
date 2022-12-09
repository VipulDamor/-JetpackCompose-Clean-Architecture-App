package com.one993.notescleanarchitecture.data.datasource.api

import com.one993.notescleanarchitecture.domain.model.meal_category.MealCategoryResponse
import com.one993.notescleanarchitecture.utils.AppConstant
import retrofit2.Response
import retrofit2.http.GET

interface MealCategoryService {

    @GET(AppConstant.ENDPOINT_CATEGORY)
    suspend fun getMealCategory(): Response<MealCategoryResponse>

}