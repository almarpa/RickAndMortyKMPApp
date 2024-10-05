package com.almarpa.rickandmortyapp.ui

import androidx.paging.PagingData
import com.almarpa.rickandmortyapp.domain.model.EpisodeModel
import kotlinx.coroutines.flow.Flow

interface EpisodesUseCase {
    
    fun getAllEpisodes(): Flow<PagingData<EpisodeModel>>
    suspend fun getEpisodesForCharacter(episodes: List<String>): List<EpisodeModel>
}
