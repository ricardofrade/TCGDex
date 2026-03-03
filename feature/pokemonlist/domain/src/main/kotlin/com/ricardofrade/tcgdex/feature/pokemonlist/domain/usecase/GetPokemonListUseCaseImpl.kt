package com.ricardofrade.tcgdex.feature.pokemonlist.domain.usecase

import com.ricardofrade.tcgdex.feature.pokemonlist.domain.model.PokemonCard
import com.ricardofrade.tcgdex.feature.pokemonlist.domain.repository.PokemonRepository
import javax.inject.Inject

class GetPokemonListUseCaseImpl @Inject constructor(
    private val repository: PokemonRepository
) : GetPokemonListUseCase {
    override suspend operator fun invoke(nameFilter: String?): Result<List<PokemonCard>> {
        return repository.getPokemonCards(nameFilter)
    }
}
