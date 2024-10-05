package com.almarpa.rickandmortyapp.ui

import androidx.paging.PagingData
import com.almarpa.rickandmortyapp.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow

interface CharacterUseCase {
    
    suspend fun getRandomCharacter(): CharacterModel
    fun getAllCharacters(): Flow<PagingData<CharacterModel>>
}
