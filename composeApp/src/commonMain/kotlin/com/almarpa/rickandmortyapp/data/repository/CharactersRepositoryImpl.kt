package com.almarpa.rickandmortyapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.almarpa.rickandmortyapp.data.database.RickAndMortyDatabase
import com.almarpa.rickandmortyapp.data.remote.CharactersApi
import com.almarpa.rickandmortyapp.data.remote.paging.CharactersPagingSource
import com.almarpa.rickandmortyapp.domain.CharactersRepository
import com.almarpa.rickandmortyapp.domain.model.CharacterModel
import com.almarpa.rickandmortyapp.domain.model.CharacterOfTheDayModel
import kotlinx.coroutines.flow.Flow

class CharactersRepositoryImpl(
    private val api: CharactersApi,
    private val database: RickAndMortyDatabase,
    private val charactersPagingSource: CharactersPagingSource,
) : CharactersRepository {

    companion object {
        const val MAX_ITEMS = 20
        const val PREFETCH_ITEMS = 5
    }

    override suspend fun getSingleCharacter(id: String): CharacterModel =
        api.getSingleCharacter(id).toDomain()

    override fun getAllCharacters(): Flow<PagingData<CharacterModel>> =
        Pager(
            config = PagingConfig(pageSize = MAX_ITEMS, prefetchDistance = PREFETCH_ITEMS),
            pagingSourceFactory = { charactersPagingSource }
        ).flow

    override suspend fun getCharacterLocal(): CharacterOfTheDayModel? =
        database.getPreferencesDao().getCharacterOfTheDay()?.toDomain()

    override suspend fun saveCharacterLocal(character: CharacterOfTheDayModel) {
        database.getPreferencesDao().saveCharacter(character.toEntity())
    }
}