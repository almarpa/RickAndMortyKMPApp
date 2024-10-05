package com.almarpa.rickandmortyapp.domain.impl

import androidx.paging.PagingData
import com.almarpa.rickandmortyapp.domain.CharactersRepository
import com.almarpa.rickandmortyapp.domain.model.CharacterModel
import com.almarpa.rickandmortyapp.domain.model.CharacterOfTheDayModel
import com.almarpa.rickandmortyapp.ui.CharacterUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class CharacterUseCaseImpl(
    private val charactersRepository: CharactersRepository
) : CharacterUseCase {

    override suspend fun getRandomCharacter(): CharacterModel {
        val characterOfTheDay: CharacterOfTheDayModel? = charactersRepository.getCharacterLocal()
        val selectedDay = getCurrentDayOfTheYear()
        return if (characterOfTheDay != null && characterOfTheDay.selectedDay == selectedDay) {
            characterOfTheDay.characterModel
        } else {
            generateRandomCharacter().also { randomCharacter ->
                saveCharacterOfTheDay(randomCharacter, selectedDay)
            }
        }
    }


    override fun getAllCharacters(): Flow<PagingData<CharacterModel>> {
        return charactersRepository.getAllCharacters()
    }

    private suspend fun generateRandomCharacter(): CharacterModel {
        val random: Int = (1..826).random()
        return charactersRepository.getSingleCharacter(random.toString())
    }

    private fun getCurrentDayOfTheYear(): String {
        val instant: Instant = Clock.System.now()
        val localTime: LocalDateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
        return "${localTime.dayOfYear}${localTime.year}"
    }

    private suspend fun saveCharacterOfTheDay(
        randomCharacter: CharacterModel,
        selectedDay: String
    ) {
        charactersRepository.saveCharacterLocal(
            CharacterOfTheDayModel(
                characterModel = randomCharacter,
                selectedDay = selectedDay
            )
        )
    }
}
