package com.almarpa.rickandmortyapp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.almarpa.rickandmortyapp.ui.core.navigation.AppNavHost

@Composable
fun App() {
    MaterialTheme {
        AppNavHost()
    }
}