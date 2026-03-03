package com.ricardofrade.tcgdex.feature.pokemonlist.ui

import com.ricardofrade.tcgdex.feature.pokemonlist.domain.model.PokemonCard

sealed class PokemonListState {
    abstract val searchQuery: String

    data class Loading(override val searchQuery: String = "") : PokemonListState()

    data class Success(
        val cards: List<PokemonCard>,
        override val searchQuery: String = ""
    ) : PokemonListState()

    data class Error(
        val message: String,
        override val searchQuery: String = ""
    ) : PokemonListState()
}

sealed interface PokemonListIntent {
    object LoadInitial : PokemonListIntent
    data class Search(val query: String) : PokemonListIntent
    data class OnCardClicked(val cardId: String) : PokemonListIntent
}

sealed interface PokemonListEffect {
    data class NavigateToDetails(val cardId: String) : PokemonListEffect
    data class ShowToast(val message: String) : PokemonListEffect
}
