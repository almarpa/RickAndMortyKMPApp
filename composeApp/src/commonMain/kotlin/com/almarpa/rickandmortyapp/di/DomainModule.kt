package com.almarpa.rickandmortyapp.di

import com.almarpa.rickandmortyapp.domain.impl.CharacterUseCaseImpl
import com.almarpa.rickandmortyapp.domain.impl.EpisodesUseCaseImpl
import com.almarpa.rickandmortyapp.ui.CharacterUseCase
import com.almarpa.rickandmortyapp.ui.EpisodesUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<CharacterUseCase> { CharacterUseCaseImpl(get()) }
    factory<EpisodesUseCase> { EpisodesUseCaseImpl(get()) }
}