package com.almarpa.rickandmortyapp.domain

import androidx.paging.PagingData
import com.almarpa.rickandmortyapp.domain.model.EpisodeModel
import kotlinx.coroutines.flow.Flow

interface EpisodesRepository {
    
    fun getAllEpisodes(): Flow<PagingData<EpisodeModel>>
    suspend fun getEpisodesForCharacter(episodes: List<String>): List<EpisodeModel>
}