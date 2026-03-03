package com.ricardofrade.tcgdex.feature.pokemonlist.data.repository

import com.ricardofrade.tcgdex.core.database.CacheDao
import com.ricardofrade.tcgdex.core.database.CacheEntity
import com.ricardofrade.tcgdex.core.network.IoDispatcher
import com.ricardofrade.tcgdex.feature.pokemonlist.data.dto.PokemonCardDto
import com.ricardofrade.tcgdex.feature.pokemonlist.data.remote.PokemonApi
import com.ricardofrade.tcgdex.feature.pokemonlist.domain.model.PokemonCard
import com.ricardofrade.tcgdex.feature.pokemonlist.domain.repository.PokemonRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val api: PokemonApi,
    private val cacheDao: CacheDao,
    private val json: Json,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : PokemonRepository {

    override suspend fun getPokemonCards(
        nameFilter: String?
    ): Result<List<PokemonCard>> = withContext(ioDispatcher) {
        val cacheKey = "cards_name_${nameFilter ?: ""}"
        val currentTime = System.currentTimeMillis()
        val cacheValidityMs = 24 * 60 * 60 * 1000L

        try {
            val cachedEntity = cacheDao.getCache(cacheKey)
            if (cachedEntity != null && (currentTime - cachedEntity.timestamp) < cacheValidityMs) {

                val dtoList = json.decodeFromString<List<PokemonCardDto>>(cachedEntity.payload)
                return@withContext Result.success(dtoList.map { it.toDomain() })
            }

            val dtoList = api.getCards(nameFilter)

            val payload = json.encodeToString(dtoList)
            cacheDao.insertCache(
                CacheEntity(
                    key = cacheKey,
                    payload = payload,
                    timestamp = currentTime
                )
            )

            Result.success(dtoList.map { it.toDomain() })
        } catch (e: Exception) {

            val staleCache = cacheDao.getCache(cacheKey)
            if (staleCache != null) {
                try {
                    val dtoList = json.decodeFromString<List<PokemonCardDto>>(staleCache.payload)
                    return@withContext Result.success(dtoList.map { it.toDomain() })
                } catch (jsonEx: Exception) {
                    return@withContext Result.failure(e)
                }
            }
            Result.failure(e)
        }
    }

    private fun PokemonCardDto.toDomain() = PokemonCard(
        id = id,
        localId = localId ?: "",
        name = name,
        image = image ?: ""
    )
}
