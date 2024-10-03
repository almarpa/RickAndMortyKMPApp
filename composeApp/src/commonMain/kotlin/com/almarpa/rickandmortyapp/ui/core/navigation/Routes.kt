package com.almarpa.rickandmortyapp.ui.core.navigation

sealed class Routes(val route:String){
    data object Home: Routes("home")

    // BottomNavigation
    data object Episodes: Routes("episodes")
    data object Characters: Routes("characters")
}

//@Serializable
//data class CharacterDetail(val characterModel: String)