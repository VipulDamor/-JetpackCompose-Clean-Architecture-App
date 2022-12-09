package com.one993.notescleanarchitecture.domain.usecase

import android.util.Log
import com.one993.notescleanarchitecture.domain.model.meal_category.MealCategoryResponse
import com.one993.notescleanarchitecture.domain.repository.MealCategoryRepository
import com.one993.notescleanarchitecture.utils.ApiResponse
import com.one993.notescleanarchitecture.utils.AppConstant
import com.one993.notescleanarchitecture.utils.AppConstant.GLOBAL_ERROR_MESSAGE
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import java.lang.reflect.Proxy
import javax.inject.Inject
import javax.inject.Named

class MealCategoryUseCase @Inject constructor(@Named(AppConstant.KEY_PROVIDER_MEAL_CATEGORY) private val mealCategoryRepository: MealCategoryRepository) {

    operator fun invoke(): Flow<ApiResponse<MealCategoryResponse?>> = flow {
        emit(ApiResponse.Loading())
        val response = mealCategoryRepository.getMealCategory()
        Log.d("TAG", "invoke: ${response.code() } ${response.message()}")
        if (response.isSuccessful) {
            emit(ApiResponse.Success(data = response.body()))
        } else {
            //todo we don't know the exact error body return from api so currently Sending error body as message
            emit(ApiResponse.Error(message = response.errorBody()?.string()
                    ?: "${response.code()} : ${response.message()}"
                )
            )
        }
    }.catch { cause ->  
        emit(ApiResponse.Error(message = cause.localizedMessage?:GLOBAL_ERROR_MESSAGE))
    }
}