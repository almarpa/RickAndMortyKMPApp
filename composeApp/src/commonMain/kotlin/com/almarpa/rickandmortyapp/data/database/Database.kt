package com.almarpa.rickandmortyapp.data.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import com.almarpa.rickandmortyapp.data.database.dao.UserPreferencesDAO
import com.almarpa.rickandmortyapp.data.database.entity.CharacterOfTheDayEntity

const val DATABASE_NAME = "rm_database.db"

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object RickAndMortyCTor : RoomDatabaseConstructor<RickAndMortyDatabase>

@Database(entities = [CharacterOfTheDayEntity::class], version = 2)
@ConstructedBy(RickAndMortyCTor::class)
abstract class RickAndMortyDatabase : RoomDatabase() {
    abstract fun getPreferencesDao(): UserPreferencesDAO
}
