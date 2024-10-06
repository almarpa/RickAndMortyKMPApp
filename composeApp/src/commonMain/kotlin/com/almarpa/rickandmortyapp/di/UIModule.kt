package com.almarpa.rickandmortyapp.di

import com.almarpa.rickandmortyapp.ui.detail.CharacterDetailViewModel
import com.almarpa.rickandmortyapp.ui.home.tabs.characters.CharactersViewModel
import com.almarpa.rickandmortyapp.ui.home.tabs.episodes.EpisodesViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module


val uiModule = module {
    viewModelOf(::EpisodesViewModel)
    viewModelOf(::CharactersViewModel)
    viewModelOf(::CharacterDetailViewModel)
}
