package com.almarpa.rickandmortyapp.domain.impl

import androidx.paging.PagingData
import com.almarpa.rickandmortyapp.domain.EpisodesRepository
import com.almarpa.rickandmortyapp.domain.model.EpisodeModel
import com.almarpa.rickandmortyapp.ui.EpisodesUseCase
import kotlinx.coroutines.flow.Flow

class EpisodesUseCaseImpl(private val episodesRepository: EpisodesRepository) : EpisodesUseCase {

    override fun getAllEpisodes(): Flow<PagingData<EpisodeModel>> =
        episodesRepository.getAllEpisodes()

    override suspend fun getEpisodesForCharacter(episodes: List<String>): List<EpisodeModel> =
        episodesRepository.getEpisodesForCharacter(episodes)
}
