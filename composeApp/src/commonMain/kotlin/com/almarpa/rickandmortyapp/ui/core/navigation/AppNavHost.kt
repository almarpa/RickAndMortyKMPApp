package com.almarpa.rickandmortyapp.ui.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.almarpa.rickandmortyapp.domain.model.CharacterModel
import com.almarpa.rickandmortyapp.ui.detail.CharacterDetailScreen
import com.almarpa.rickandmortyapp.ui.home.HomeScreen

@Composable
fun AppNavHost() {
    val mainNavController = rememberNavController()
    val navigationActions = remember(mainNavController) { NavigationActions(mainNavController) }

    NavHost(navController = mainNavController, startDestination = Routes.Home) {
        composable<Routes.Home> {
            HomeScreen(navigationActions)
        }
        composable<CharacterModel> { navBackStackEntry ->
            val characterModel: CharacterModel = navBackStackEntry.toRoute<CharacterModel>()
            CharacterDetailScreen(
                characterModel = characterModel,
                onBackPressed = { mainNavController.popBackStack() })
        }
    }
}