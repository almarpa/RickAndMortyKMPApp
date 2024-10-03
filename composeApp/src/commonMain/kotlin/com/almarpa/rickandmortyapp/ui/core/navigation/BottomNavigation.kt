package com.almarpa.rickandmortyapp.ui.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.almarpa.rickandmortyapp.ui.home.tabs.characters.CharactersScreen
import com.almarpa.rickandmortyapp.ui.home.tabs.episodes.EpisodesScreen

@Composable
fun BottomNavigation(navController: NavHostController, mainNavController: NavHostController){

    NavHost(navController = navController, startDestination = Routes.Episodes.route){

        composable(route = Routes.Episodes.route){
            EpisodesScreen()
        }

        composable(route = Routes.Characters.route){
            CharactersScreen()
        }
    }

}