package com.ricardofrade.tcgdex.feature.pokemondetail.data.remote

import com.ricardofrade.tcgdex.feature.pokemondetail.data.dto.PokemonCardDetailDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

class PokemonDetailApi @Inject constructor(
    private val httpClient: HttpClient
) {
    suspend fun getCardDetail(cardId: String): PokemonCardDetailDto {
        return httpClient.get("v2/en/cards/$cardId").body()
    }
}
