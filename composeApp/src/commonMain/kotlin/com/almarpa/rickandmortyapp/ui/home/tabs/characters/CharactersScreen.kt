package com.almarpa.rickandmortyapp.ui.home.tabs.characters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.almarpa.rickandmortyapp.ui.theme.BackgroundPrimaryColor
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun CharactersScreen() {
    val charactersViewModel = koinViewModel<CharactersViewModel>()
    val state by charactersViewModel.state.collectAsState()

    Column(Modifier.fillMaxSize().background(BackgroundPrimaryColor)) {
        Spacer(Modifier.height(16.dp))

    }
}