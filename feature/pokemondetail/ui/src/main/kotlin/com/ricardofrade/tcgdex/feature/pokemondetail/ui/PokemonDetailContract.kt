package com.ricardofrade.tcgdex.feature.pokemondetail.ui

import com.ricardofrade.tcgdex.feature.pokemondetail.domain.model.PokemonCardDetail

sealed class PokemonDetailState {
    data object Loading : PokemonDetailState()
    data class Success(val card: PokemonCardDetail) : PokemonDetailState()
    data class Error(val message: String) : PokemonDetailState()
}

sealed interface PokemonDetailIntent {
    data class LoadCard(val cardId: String) : PokemonDetailIntent
    object OnBackClicked : PokemonDetailIntent
}

sealed interface PokemonDetailEffect {
    object NavigateBack : PokemonDetailEffect
    data class ShowToast(val message: String) : PokemonDetailEffect
}
