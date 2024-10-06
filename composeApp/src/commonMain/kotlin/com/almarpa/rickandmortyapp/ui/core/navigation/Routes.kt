package com.almarpa.rickandmortyapp.ui.core.navigation

import kotlinx.serialization.Serializable

/**
 * Destinations used throughout the app.
 */
sealed class Routes {
    @Serializable
    data object Home : Routes()

    @Serializable
    data object Episodes : Routes()

    @Serializable
    data object Characters : Routes()
}
