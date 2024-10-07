package com.almarpa.rickandmortyapp.ui.core.navigation

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.almarpa.rickandmortyapp.ui.home.tabs.characters.CharactersScreen
import com.almarpa.rickandmortyapp.ui.home.tabs.episodes.EpisodesScreen
import com.almarpa.rickandmortyapp.ui.theme.BackgroundPrimaryColor

@Composable
fun BottomNavHost(
    navController: NavHostController,
    navigationActions: NavigationActions,
) {
    NavHost(
        modifier = Modifier.background(BackgroundPrimaryColor),
        navController = navController,
        startDestination = Routes.Characters,
    ) {
        composable<Routes.Characters> {
            CharactersScreen(
                navigateToDetail = { character ->
                    navigationActions.navigateToCharacterDetail(character)
                }
            )
        }
        composable<Routes.Episodes> {
            EpisodesScreen()
        }
    }
}