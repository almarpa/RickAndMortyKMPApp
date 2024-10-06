package com.almarpa.rickandmortyapp.ui.core.navigation

import androidx.navigation.NavHostController
import com.almarpa.rickandmortyapp.domain.model.CharacterModel

/**
 * Models AppNavHost actions in the app.
 */
class NavigationActions(private val navController: NavHostController) {
    val navigateToCharacterDetail: (CharacterModel) -> Unit = { character ->
        navController.navigate(character)
    }
}