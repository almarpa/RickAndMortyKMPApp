package com.almarpa.rickandmortyapp.ui

import com.almarpa.rickandmortyapp.domain.model.CharacterModel

interface CharacterUseCase {
    suspend fun getRandomCharacter(): CharacterModel
}
