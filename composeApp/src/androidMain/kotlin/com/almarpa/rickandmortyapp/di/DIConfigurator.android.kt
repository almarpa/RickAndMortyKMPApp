package com.almarpa.rickandmortyapp.di

import com.almarpa.rickandmortyapp.data.database.RickAndMortyDatabase
import com.almarpa.rickandmortyapp.data.database.getDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module {
    return module {
        single<RickAndMortyDatabase> { getDatabase(get()) }
    }
}