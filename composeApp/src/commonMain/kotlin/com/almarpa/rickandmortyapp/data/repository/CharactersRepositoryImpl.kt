package com.almarpa.rickandmortyapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.almarpa.rickandmortyapp.data.remote.CharactersApi
import com.almarpa.rickandmortyapp.data.remote.paging.CharactersPagingSource
import com.almarpa.rickandmortyapp.domain.CharactersRepository
import com.almarpa.rickandmortyapp.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow

class CharactersRepositoryImpl(
    private val api: CharactersApi,
    private val charactersPagingSource: CharactersPagingSource,
) : CharactersRepository {

    companion object {
        const val MAX_ITEMS = 20
        const val PREFETCH_ITEMS = 5
    }

    override suspend fun getSingleCharacter(id: String): CharacterModel {
        return api.getSingleCharacter(id).toDomain()
    }

    override fun getAllCharacters(): Flow<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(pageSize = MAX_ITEMS, prefetchDistance = PREFETCH_ITEMS),
            pagingSourceFactory = { charactersPagingSource }
        ).flow
    }
}