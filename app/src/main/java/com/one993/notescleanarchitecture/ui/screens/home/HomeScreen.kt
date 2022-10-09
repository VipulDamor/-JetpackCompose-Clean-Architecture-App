package com.one993.notescleanarchitecture.ui.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun HomeScreen(name: String) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        // A surface container using the 'background' color from the theme
        color = MaterialTheme.colorScheme.background
    ) {
        Text(text = "Hello $name!")
    }
}

