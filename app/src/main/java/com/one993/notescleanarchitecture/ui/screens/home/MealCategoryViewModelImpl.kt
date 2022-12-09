package com.one993.notescleanarchitecture.ui.screens.home

import androidx.lifecycle.viewModelScope
import com.one993.notescleanarchitecture.domain.usecase.MealCategoryUseCase
import com.one993.notescleanarchitecture.utils.ApiResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MealCategoryViewModelImpl @Inject constructor(private val mealCategoryUseCase: MealCategoryUseCase) :
    MealCategoryViewModel() {

    init {
        getMealCategory()
    }

    override fun getMealCategory() {
        mealCategoryUseCase().onEach {
            when (it) {
                is ApiResponse.Loading -> {
                    isLoading.value = true

                }
                is ApiResponse.Success -> {
                    isLoading.value = false
                    it.data?.categories?.let { mealCategoryListData ->
                        mealCategoryList.addAll(mealCategoryListData)
                    }
                }
                is ApiResponse.Error -> {
                    isLoading.value = false
                }

            }
        }.catch { cause: Throwable ->
            cause.printStackTrace()
        }.launchIn(viewModelScope)
    }
}