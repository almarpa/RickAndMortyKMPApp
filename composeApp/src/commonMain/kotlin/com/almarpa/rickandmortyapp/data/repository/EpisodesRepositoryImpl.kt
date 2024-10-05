package com.almarpa.rickandmortyapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.almarpa.rickandmortyapp.data.remote.EpisodesApi
import com.almarpa.rickandmortyapp.data.remote.paging.EpisodesPagingSource
import com.almarpa.rickandmortyapp.domain.EpisodesRepository
import com.almarpa.rickandmortyapp.domain.model.EpisodeModel
import kotlinx.coroutines.flow.Flow

class EpisodesRepositoryImpl(
    private val episodesApi: EpisodesApi,
    private val episodesPagingSource: EpisodesPagingSource,
) : EpisodesRepository {

    companion object {
        const val MAX_ITEMS = 20
        const val PREFETCH_ITEMS = 5
    }

    override fun getAllEpisodes(): Flow<PagingData<EpisodeModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = MAX_ITEMS,
                prefetchDistance = PREFETCH_ITEMS
            ),
            pagingSourceFactory = { episodesPagingSource }).flow
    }

    override suspend fun getEpisodesForCharacter(episodes: List<String>): List<EpisodeModel> {
        return when {
            episodes.isEmpty() -> emptyList()

            episodes.size > 1 -> {
                episodesApi.getEpisodes(episodes.joinToString(",")).map { episodeResponse ->
                    episodeResponse.toDomain()
                }
            }

            else -> listOf(episodesApi.getSingleEpisode(episodes.first()).toDomain())
        }
    }
}