package com.one993.notescleanarchitecture.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.one993.notescleanarchitecture.ui.screens.home.MealCategoryScreen


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = NavigationScreens.Home.route) {
        composable(route = NavigationScreens.Home.route) {
            MealCategoryScreen()
        }
    }

}