package com.ricardofrade.tcgdex.feature.pokemondetail.data.di

import com.ricardofrade.tcgdex.feature.pokemondetail.data.repository.PokemonDetailRepositoryImpl
import com.ricardofrade.tcgdex.feature.pokemondetail.domain.repository.PokemonDetailRepository
import com.ricardofrade.tcgdex.feature.pokemondetail.domain.usecase.GetPokemonDetailUseCase
import com.ricardofrade.tcgdex.feature.pokemondetail.domain.usecase.GetPokemonDetailUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PokemonDetailDataModule {

    @Binds
    @Singleton
    abstract fun bindPokemonDetailRepository(
        pokemonDetailRepositoryImpl: PokemonDetailRepositoryImpl
    ): PokemonDetailRepository

    @Binds
    @Singleton
    abstract fun bindGetPokemonDetailUseCase(
        getPokemonDetailUseCaseImpl: GetPokemonDetailUseCaseImpl
    ): GetPokemonDetailUseCase
}
