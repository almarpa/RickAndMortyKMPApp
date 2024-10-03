package com.almarpa.rickandmortyapp.di

import com.almarpa.rickandmortyapp.data.remote.paging.CharactersPagingSource
import com.almarpa.rickandmortyapp.data.repository.CharactersRepositoryImpl
import com.almarpa.rickandmortyapp.domain.CharactersRepository
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val dataModule = module {
    factory<CharactersRepository> { CharactersRepositoryImpl(get(), get()) }
    factoryOf(::CharactersPagingSource)
    //factoryOf(::EpisodesPagingSource)
}