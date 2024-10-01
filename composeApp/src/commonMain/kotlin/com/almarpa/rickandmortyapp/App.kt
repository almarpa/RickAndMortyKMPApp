package com.almarpa.rickandmortyapp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.almarpa.rickandmortyapp.ui.core.NavigationWrapper
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        NavigationWrapper()
    }
}