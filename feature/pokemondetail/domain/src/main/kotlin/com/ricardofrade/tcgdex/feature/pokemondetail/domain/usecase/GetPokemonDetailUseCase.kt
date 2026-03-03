package com.ricardofrade.tcgdex.feature.pokemondetail.domain.usecase

import com.ricardofrade.tcgdex.feature.pokemondetail.domain.model.PokemonCardDetail

interface GetPokemonDetailUseCase {
    suspend operator fun invoke(cardId: String): Result<PokemonCardDetail>
}
