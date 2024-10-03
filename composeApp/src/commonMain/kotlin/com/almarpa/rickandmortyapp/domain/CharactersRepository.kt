package com.almarpa.rickandmortyapp.domain

import androidx.paging.PagingData
import com.almarpa.rickandmortyapp.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {
    suspend fun getSingleCharacter(id: String): CharacterModel
    fun getAllCharacters(): Flow<PagingData<CharacterModel>>
}