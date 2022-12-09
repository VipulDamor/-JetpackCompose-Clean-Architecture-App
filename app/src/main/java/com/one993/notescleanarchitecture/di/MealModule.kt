package com.one993.notescleanarchitecture.di

import com.one993.notescleanarchitecture.data.datasource.api.MealCategoryService
import com.one993.notescleanarchitecture.data.repository.MealCategoryRepositoryImpl
import com.one993.notescleanarchitecture.domain.repository.MealCategoryRepository
import com.one993.notescleanarchitecture.utils.AppConstant
import com.one993.notescleanarchitecture.utils.AppConstant.KEY_PROVIDER_CATEGORY_SERVICE
import com.one993.notescleanarchitecture.utils.AppConstant.KEY_PROVIDER_MEAL_CATEGORY
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object MealModule {

    @Provides
    @Named(KEY_PROVIDER_CATEGORY_SERVICE)
    fun provideCategoryService(): MealCategoryService = Retrofit
        .Builder()
        .baseUrl(AppConstant.BASE_URL)
        .client(OkHttpClient.Builder().build())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MealCategoryService::class.java)

    @Provides
    @Named(KEY_PROVIDER_MEAL_CATEGORY)
    fun getMealCategory(@Named("CategoryService") categoryService: MealCategoryService):MealCategoryRepository{
        return MealCategoryRepositoryImpl(categoryService)
    }

}