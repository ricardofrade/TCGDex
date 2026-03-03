package com.ricardofrade.tcgdex.feature.pokemondetail.data.repository

import com.ricardofrade.tcgdex.core.database.CacheDao
import com.ricardofrade.tcgdex.core.database.CacheEntity
import com.ricardofrade.tcgdex.core.network.IoDispatcher
import com.ricardofrade.tcgdex.feature.pokemondetail.data.dto.PokemonCardDetailDto
import com.ricardofrade.tcgdex.feature.pokemondetail.data.remote.PokemonDetailApi
import com.ricardofrade.tcgdex.feature.pokemondetail.domain.model.PokemonCardDetail
import com.ricardofrade.tcgdex.feature.pokemondetail.domain.repository.PokemonDetailRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import javax.inject.Inject

class PokemonDetailRepositoryImpl @Inject constructor(
    private val api: PokemonDetailApi,
    private val cacheDao: CacheDao,
    private val json: Json,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : PokemonDetailRepository {

    override suspend fun getPokemonDetail(cardId: String): Result<PokemonCardDetail> =
        withContext(ioDispatcher) {
            val cacheKey = "card_detail_$cardId"
            val currentTime = System.currentTimeMillis()
            val cacheValidityMs = 24 * 60 * 60 * 1000L

            try {
                val cachedEntity = cacheDao.getCache(cacheKey)
                if (cachedEntity != null && (currentTime - cachedEntity.timestamp) < cacheValidityMs) {
                    val dto = json.decodeFromString<PokemonCardDetailDto>(cachedEntity.payload)
                    return@withContext Result.success(dto.toDomain())
                }

                val dto = api.getCardDetail(cardId)

                val payload = json.encodeToString(dto)
                cacheDao.insertCache(
                    CacheEntity(
                        key = cacheKey,
                        payload = payload,
                        timestamp = currentTime
                    )
                )

                Result.success(dto.toDomain())
            } catch (e: Exception) {
                val staleCache = cacheDao.getCache(cacheKey)
                if (staleCache != null) {
                    try {
                        val dto = json.decodeFromString<PokemonCardDetailDto>(staleCache.payload)
                        return@withContext Result.success(dto.toDomain())
                    } catch (jsonEx: Exception) {
                        return@withContext Result.failure(e)
                    }
                }
                Result.failure(e)
            }
        }

    private fun PokemonCardDetailDto.toDomain() = PokemonCardDetail(
        id = id,
        name = name,
        image = image ?: "",
        hp = hp ?: 0,
        types = types ?: emptyList(),
        rarity = rarity ?: "Unknown",
        illustrator = illustrator ?: "Unknown"
    )
}
