package com.ricardofrade.tcgdex.feature.pokemonlist.data.remote

import com.ricardofrade.tcgdex.feature.pokemonlist.data.dto.PokemonCardDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import javax.inject.Inject

class PokemonApi @Inject constructor(
    private val httpClient: HttpClient
) {
    suspend fun getCards(nameFilter: String?): List<PokemonCardDto> {
        return httpClient.get("v2/en/cards") {
            nameFilter?.let { parameter("name", it) }
        }.body()
    }
}
