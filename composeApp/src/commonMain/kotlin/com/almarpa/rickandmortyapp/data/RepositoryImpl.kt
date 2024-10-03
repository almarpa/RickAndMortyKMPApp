package com.almarpa.rickandmortyapp.data

import com.almarpa.rickandmortyapp.data.remote.ApiService
import com.almarpa.rickandmortyapp.domain.Repository
import com.almarpa.rickandmortyapp.domain.model.CharacterModel

class RepositoryImpl(
    private val api: ApiService,
) : Repository {

    override suspend fun getSingleCharacter(id: String): CharacterModel {
        return api.getSingleCharacter(id).toDomain()
    }

//    override fun getAllCharacters(): Flow<PagingData<CharacterModel>> {
//        return Pager(config = PagingConfig(pageSize = MAX_ITEMS, prefetchDistance = PREFETCH_ITEMS),
//            pagingSourceFactory = { charactersPagingSource }).flow
//    }
}