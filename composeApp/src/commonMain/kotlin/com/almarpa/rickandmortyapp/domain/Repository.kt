package com.almarpa.rickandmortyapp.domain

import com.almarpa.rickandmortyapp.domain.model.CharacterModel

interface Repository {
    suspend fun getSingleCharacter(id:String): CharacterModel
    // fun getAllCharacters(): Flow<PagingData<CharacterModel>>
}