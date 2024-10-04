package com.almarpa.rickandmortyapp.domain

import androidx.paging.PagingData
import com.almarpa.rickandmortyapp.domain.model.CharacterModel
import com.almarpa.rickandmortyapp.domain.model.CharacterOfTheDayModel
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {
    suspend fun getSingleCharacter(id: String): CharacterModel
    fun getAllCharacters(): Flow<PagingData<CharacterModel>>
    suspend fun getCharacterLocal(): CharacterOfTheDayModel?
    suspend fun saveCharacterLocal(character: CharacterOfTheDayModel)
}