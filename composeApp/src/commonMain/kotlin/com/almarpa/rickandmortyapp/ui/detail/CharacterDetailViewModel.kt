package com.almarpa.rickandmortyapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.almarpa.rickandmortyapp.domain.model.CharacterModel
import com.almarpa.rickandmortyapp.domain.model.EpisodeModel
import com.almarpa.rickandmortyapp.ui.EpisodesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

data class CharacterDetailState(
    val characterModel: CharacterModel,
    val episodes: List<EpisodeModel> = emptyList()
)

class CharacterDetailViewModel(
    characterModel: CharacterModel,
    private val episodesUseCase: EpisodesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(CharacterDetailState(characterModel))
    val uiState: StateFlow<CharacterDetailState> = _uiState

    init {
        getEpisodesForCharacter(characterModel.episodes)
    }

    private fun getEpisodesForCharacter(episodes: List<String>) {
        viewModelScope.launch {
            val characterEpisodes = withContext(Dispatchers.IO) {
                episodesUseCase.getEpisodesForCharacter(episodes)
            }
            _uiState.update { it.copy(episodes = characterEpisodes) }
        }
    }
}