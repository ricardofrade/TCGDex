package com.ricardofrade.tcgdex.feature.pokemonlist.domain.usecase

import com.ricardofrade.tcgdex.feature.pokemonlist.domain.model.PokemonCard

interface GetPokemonListUseCase {
    suspend operator fun invoke(nameFilter: String? = null): Result<List<PokemonCard>>
}
