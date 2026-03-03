package com.ricardofrade.tcgdex.feature.pokemondetail.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class PokemonCardDetailDto(
    val id: String,
    val name: String,
    val image: String? = null,
    val hp: Int? = null,
    val types: List<String>? = null,
    val rarity: String? = null,
    val illustrator: String? = null
)
