package com.almarpa.rickandmortyapp.ui.core.navigation

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import rickandmortyapp.composeapp.generated.resources.Res
import rickandmortyapp.composeapp.generated.resources.ic_characters
import rickandmortyapp.composeapp.generated.resources.ic_player

sealed class BottomBarItem {
    abstract val route: Routes
    abstract val title: String
    abstract val icon: @Composable () -> Unit

    data class Characters(
        override val route: Routes = Routes.Characters,
        override val title: String = "Characters",
        override val icon: @Composable () -> Unit = {
            Icon(
                painter = painterResource(Res.drawable.ic_characters),
                "charactersTabItem",
                modifier = Modifier.size(24.dp)
            )
        }
    ) : BottomBarItem()

    data class Episodes(
        override val route: Routes = Routes.Episodes,
        override val title: String = "Episodes",
        override val icon: @Composable () -> Unit = {
            Icon(
                painter = painterResource(Res.drawable.ic_player),
                "episodesTabItem",
                modifier = Modifier.size(24.dp)
            )
        }
    ) : BottomBarItem()
}