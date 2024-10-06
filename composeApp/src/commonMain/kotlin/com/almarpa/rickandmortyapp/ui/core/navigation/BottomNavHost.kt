package com.almarpa.rickandmortyapp.ui.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.almarpa.rickandmortyapp.ui.home.tabs.characters.CharactersScreen
import com.almarpa.rickandmortyapp.ui.home.tabs.episodes.EpisodesScreen

@Composable
fun BottomNavHost(navController: NavHostController, navigationActions: NavigationActions) {
    NavHost(
        navController = navController,
        startDestination = Routes.Episodes
    ) {
        composable<Routes.Episodes> {
            EpisodesScreen()
        }
        composable<Routes.Characters> {
            CharactersScreen(
                navigateToDetail = { character ->
                    navigationActions.navigateToCharacterDetail(character)
                }
            )
        }
    }
}