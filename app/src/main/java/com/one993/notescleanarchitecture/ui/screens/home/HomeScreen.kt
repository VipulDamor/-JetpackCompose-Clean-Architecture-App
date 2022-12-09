package com.one993.notescleanarchitecture.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun MealCategoryScreen(
    mealCategoryViewModel: MealCategoryViewModel = hiltViewModel<MealCategoryViewModelImpl>()
) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (mealCategoryViewModel.isLoading.value) {
                Text(text = "Loading Meal category..!!!")
            } else if (mealCategoryViewModel.isLoading.value) {
                Text(text = "No category Found..!!!")
            } else {

                mealCategoryViewModel.mealCategoryList.forEachIndexed { index, categoriesItem ->
                    Text(text = " ${categoriesItem?.strCategory}!")
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

