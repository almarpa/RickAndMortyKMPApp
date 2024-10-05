package com.almarpa.rickandmortyapp.data.remote

import com.almarpa.rickandmortyapp.data.remote.response.EpisodeResponse
import com.almarpa.rickandmortyapp.data.remote.response.EpisodesWrapperResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class EpisodesApi(private val client: HttpClient) {

    suspend fun getAllEpisodes(page: Int): EpisodesWrapperResponse {
        return client.get("/api/episode") {
            parameter("page", page)
        }.body()
    }

    suspend fun getEpisodes(episodes: String): List<EpisodeResponse> {
        return client.get("/api/episode/$episodes").body()
    }

    suspend fun getSingleEpisode(episodeId: String): EpisodeResponse {
        return client.get("/api/episode/$episodeId").body()
    }
}