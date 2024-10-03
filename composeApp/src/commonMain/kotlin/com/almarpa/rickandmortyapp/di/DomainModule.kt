package com.almarpa.rickandmortyapp.di

import com.almarpa.rickandmortyapp.ui.CharacterUseCase
import com.almarpa.rickandmortyapp.domain.impl.CharacterUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    factory <CharacterUseCase>{ CharacterUseCaseImpl(get()) }
}