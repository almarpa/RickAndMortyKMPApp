package com.almarpa.rickandmortyapp.ui.core.components

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.almarpa.rickandmortyapp.ui.core.navigation.BottomBarItem
import com.almarpa.rickandmortyapp.ui.theme.BackgroundSecondaryColor
import com.almarpa.rickandmortyapp.ui.theme.BackgroundTertiaryColor
import com.almarpa.rickandmortyapp.ui.theme.DefaultTextColor
import com.almarpa.rickandmortyapp.ui.theme.Green


@Composable
fun BottomBar(items: List<BottomBarItem>, navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(containerColor = BackgroundSecondaryColor, contentColor = Green) {
        items.forEach { item ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Green,
                    selectedIconColor = BackgroundTertiaryColor,
                    unselectedIconColor = Green
                ),
                icon = item.icon,
                label = { Text(item.title, color = DefaultTextColor) },
                onClick = {
                    navController.navigate(item.route) {
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                selected = currentDestination?.route?.substringAfterLast(".") == item.route.toString(),
                alwaysShowLabel = false
            )
        }
    }
}