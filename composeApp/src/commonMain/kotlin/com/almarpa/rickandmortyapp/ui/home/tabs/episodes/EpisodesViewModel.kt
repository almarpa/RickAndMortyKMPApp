package com.almarpa.rickandmortyapp.ui.home.tabs.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.almarpa.rickandmortyapp.domain.model.EpisodeModel
import com.almarpa.rickandmortyapp.ui.EpisodesUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.update

data class EpisodesState(
    val characters: Flow<PagingData<EpisodeModel>> = emptyFlow(),
    val playVideo: String = ""
)

class EpisodesViewModel(private val useCase: EpisodesUseCase) : ViewModel() {

    private val _state = MutableStateFlow(EpisodesState())
    val state: StateFlow<EpisodesState> = _state

    init {
        _state.update { state ->
            state.copy(
                characters = useCase.getAllEpisodes().cachedIn(viewModelScope)
            )
        }
    }

    fun onPlaySelected(url: String) {
        _state.update { state -> state.copy(playVideo = url) }
    }

    fun onCloseVideo() {
        _state.update { state -> state.copy(playVideo = "") }
    }
}