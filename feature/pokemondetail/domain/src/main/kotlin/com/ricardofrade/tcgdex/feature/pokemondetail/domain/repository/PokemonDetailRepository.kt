package com.ricardofrade.tcgdex.feature.pokemondetail.domain.repository

import com.ricardofrade.tcgdex.feature.pokemondetail.domain.model.PokemonCardDetail

interface PokemonDetailRepository {
    suspend fun getPokemonDetail(cardId: String): Result<PokemonCardDetail>
}
