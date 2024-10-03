package com.almarpa.rickandmortyapp.ui.home.tabs.episodes

import androidx.lifecycle.ViewModel
import com.almarpa.rickandmortyapp.domain.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

data class EpisodesState(
    // val characters: Flow<PagingData<EpisodeModel>> = emptyFlow(),
    val playVideo:String = ""
)

class EpisodesViewModel : ViewModel() {

    private val _state = MutableStateFlow(EpisodesState())
    val state: StateFlow<EpisodesState> = _state

//    init {
//        _state.update { state ->
//            state.copy(
//                characters = repository.getAllEpisodes().cachedIn(viewModelScope)
//            )
//        }
//    }

    fun onPlaySelected(url: String) {
        _state.update { state -> state.copy(playVideo = url) }
    }

    fun onCloseVideo() {
        _state.update { state -> state.copy(playVideo = "") }
    }
}