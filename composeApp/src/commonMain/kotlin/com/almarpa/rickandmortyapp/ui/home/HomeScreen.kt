package com.almarpa.rickandmortyapp.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.almarpa.rickandmortyapp.ui.core.components.BottomBar
import com.almarpa.rickandmortyapp.ui.core.components.TopBar
import com.almarpa.rickandmortyapp.ui.core.navigation.BottomBarItem.Characters
import com.almarpa.rickandmortyapp.ui.core.navigation.BottomBarItem.Episodes
import com.almarpa.rickandmortyapp.ui.core.navigation.BottomNavHost
import com.almarpa.rickandmortyapp.ui.core.navigation.NavigationActions

@Composable
fun HomeScreen(navigationActions: NavigationActions) {
    val items = listOf(Episodes(), Characters())
    val bottomNavController = rememberNavController()

    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar(items, bottomNavController) },
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            BottomNavHost(bottomNavController, navigationActions)
        }
    }
}
