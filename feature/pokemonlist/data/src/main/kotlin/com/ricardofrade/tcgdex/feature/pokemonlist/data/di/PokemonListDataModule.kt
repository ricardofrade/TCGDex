package com.ricardofrade.tcgdex.feature.pokemonlist.data.di

import com.ricardofrade.tcgdex.feature.pokemonlist.data.repository.PokemonRepositoryImpl
import com.ricardofrade.tcgdex.feature.pokemonlist.domain.repository.PokemonRepository
import com.ricardofrade.tcgdex.feature.pokemonlist.domain.usecase.GetPokemonListUseCase
import com.ricardofrade.tcgdex.feature.pokemonlist.domain.usecase.GetPokemonListUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PokemonListDataModule {

    @Binds
    @Singleton
    abstract fun bindPokemonRepository(
        pokemonRepositoryImpl: PokemonRepositoryImpl
    ): PokemonRepository

    @Binds
    @Singleton
    abstract fun bindGetPokemonListUseCase(
        getPokemonListUseCaseImpl: GetPokemonListUseCaseImpl
    ): GetPokemonListUseCase
    
    companion object {
        @Provides
        @Singleton
        fun provideJson(): Json {
            return Json {
                ignoreUnknownKeys = true
                isLenient = true
            }
        }
    }
}
