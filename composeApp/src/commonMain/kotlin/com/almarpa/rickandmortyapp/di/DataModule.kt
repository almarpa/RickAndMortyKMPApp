package com.almarpa.rickandmortyapp.di

import com.almarpa.rickandmortyapp.data.repository.RepositoryImpl
import com.almarpa.rickandmortyapp.domain.Repository
import org.koin.dsl.module

val dataModule = module {
    factory <Repository>{ RepositoryImpl(get()) }
}