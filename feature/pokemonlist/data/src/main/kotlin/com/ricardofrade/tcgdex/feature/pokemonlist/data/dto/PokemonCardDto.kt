package com.ricardofrade.tcgdex.feature.pokemonlist.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class PokemonCardDto(
    val id: String,
    val localId: String? = null,
    val name: String,
    val image: String? = null
)
