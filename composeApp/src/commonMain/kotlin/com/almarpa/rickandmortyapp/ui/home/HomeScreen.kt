package com.almarpa.rickandmortyapp.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.compose.rememberNavController
import com.almarpa.rickandmortyapp.ui.core.components.BottomBar
import com.almarpa.rickandmortyapp.ui.core.components.TopBar
import com.almarpa.rickandmortyapp.ui.core.navigation.BottomBarItem.Characters
import com.almarpa.rickandmortyapp.ui.core.navigation.BottomBarItem.Episodes
import com.almarpa.rickandmortyapp.ui.core.navigation.BottomNavHost
import com.almarpa.rickandmortyapp.ui.core.navigation.NavigationActions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navigationActions: NavigationActions) {
    val items = listOf(Characters(), Episodes())
    val bottomNavController = rememberNavController()
    val scrollBehaviour = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehaviour.nestedScrollConnection),
        topBar = {
            TopBar(scrollBehaviour = scrollBehaviour)
        },
        bottomBar = {
            BottomBar(
                items = items,
                navController = bottomNavController
            )
        },
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            BottomNavHost(bottomNavController, navigationActions)
        }
    }
}
