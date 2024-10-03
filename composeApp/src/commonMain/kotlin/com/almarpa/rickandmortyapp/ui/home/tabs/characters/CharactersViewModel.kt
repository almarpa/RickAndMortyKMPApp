package com.almarpa.rickandmortyapp.ui.home.tabs.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.almarpa.rickandmortyapp.ui.CharacterUseCase
import com.almarpa.rickandmortyapp.domain.model.CharacterModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

data class CharactersState(
    val characterOfTheDay: CharacterModel? = null,
    // val characters: Flow<PagingData<CharacterModel>> = emptyFlow()
)

class CharactersViewModel(
    private val getCharacterUseCaseImpl: CharacterUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(CharactersState())
    val state: StateFlow<CharactersState> = _state

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.update { state -> state.copy(
                        characterOfTheDay = getCharacterUseCaseImpl.getRandomCharacter()
                    )
                }
            }
        }
        getAllCharacters()
    }

    private fun getAllCharacters() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                //        _state.update { state ->
                //        state.copy(
                //            characters = repository.getAllCharacters().cachedIn(viewModelScope)
                //        )
            }
        }
    }
}