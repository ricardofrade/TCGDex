package com.ricardofrade.tcgdex.feature.pokemondetail.domain.usecase

import com.ricardofrade.tcgdex.feature.pokemondetail.domain.model.PokemonCardDetail
import com.ricardofrade.tcgdex.feature.pokemondetail.domain.repository.PokemonDetailRepository
import javax.inject.Inject

class GetPokemonDetailUseCaseImpl @Inject constructor(
    private val repository: PokemonDetailRepository
) : GetPokemonDetailUseCase {
    override suspend operator fun invoke(cardId: String): Result<PokemonCardDetail> {
        return repository.getPokemonDetail(cardId)
    }
}
