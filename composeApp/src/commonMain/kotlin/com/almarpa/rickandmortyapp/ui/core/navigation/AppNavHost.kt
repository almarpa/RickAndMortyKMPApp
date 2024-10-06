package com.almarpa.rickandmortyapp.ui.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.almarpa.rickandmortyapp.ui.home.HomeScreen

@Composable
fun AppNavHost() {
    val mainNavController = rememberNavController()
    val navigationActions = remember(mainNavController) { NavigationActions(mainNavController) }

    NavHost(navController = mainNavController, startDestination = Routes.Home) {
        composable<Routes.Home> {
            HomeScreen(navigationActions)
        }
//        composable<CharacterDetail> { navBackStackEntry ->
//            val characterDetailEncoding: CharacterDetail =
//                navBackStackEntry.toRoute<CharacterDetail>()
//            val characterModel: CharacterModel =
//                Json.decodeFromString<CharacterModel>(characterDetailEncoding.characterModel)
//            CharacterDetailScreen(
//                characterModel = characterModel,
//                onBackPressed = { mainNavController.popBackStack() })
//        }
    }
}