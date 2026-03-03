package com.ricardofrade.tcgdex.feature.pokemonlist.domain.repository

import com.ricardofrade.tcgdex.feature.pokemonlist.domain.model.PokemonCard

interface PokemonRepository {
    suspend fun getPokemonCards(nameFilter: String? = null): Result<List<PokemonCard>>
}
