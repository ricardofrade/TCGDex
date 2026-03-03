package com.ricardofrade.tcgdex.feature.pokemondetail.domain.model

data class PokemonCardDetail(
    val id: String,
    val name: String,
    val image: String,
    val hp: Int,
    val types: List<String>,
    val rarity: String,
    val illustrator: String
)
