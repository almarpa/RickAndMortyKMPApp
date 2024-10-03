package com.almarpa.rickandmortyapp.domain.impl

import com.almarpa.rickandmortyapp.ui.CharacterUseCase
import com.almarpa.rickandmortyapp.domain.Repository
import com.almarpa.rickandmortyapp.domain.model.CharacterModel
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class CharacterUseCaseImpl(private val repository: Repository): CharacterUseCase {

    override suspend fun getRandomCharacter(): CharacterModel =
//        val characterOfTheDay: CharacterOfTheDayModel? = repository.getCharacterDB()
//        val selectedDay = getCurrentDayOfTheYear()
//        return if (characterOfTheDay != null && characterOfTheDay.selectedDay == selectedDay) {
//            characterOfTheDay.characterModel
//        } else {
        generateRandomCharacter().also {
            //repository.saveCharacterDB(CharacterOfTheDayModel(characterModel = it, selectedDay))
        }

    private suspend fun generateRandomCharacter(): CharacterModel {
        val random: Int = (1..826).random()
        return repository.getSingleCharacter(random.toString())
    }

    private fun getCurrentDayOfTheYear(): String {
        val instant: Instant = Clock.System.now()
        val localTime: LocalDateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
        return "${localTime.dayOfYear}${localTime.year}"
    }
}
