package com.ricardofrade.tcgdex.feature.pokemonlist.ui;

import com.ricardofrade.tcgdex.feature.pokemonlist.domain.usecase.GetPokemonListUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class PokemonListViewModel_Factory implements Factory<PokemonListViewModel> {
  private final Provider<GetPokemonListUseCase> getPokemonListUseCaseProvider;

  private PokemonListViewModel_Factory(
      Provider<GetPokemonListUseCase> getPokemonListUseCaseProvider) {
    this.getPokemonListUseCaseProvider = getPokemonListUseCaseProvider;
  }

  @Override
  public PokemonListViewModel get() {
    return newInstance(getPokemonListUseCaseProvider.get());
  }

  public static PokemonListViewModel_Factory create(
      Provider<GetPokemonListUseCase> getPokemonListUseCaseProvider) {
    return new PokemonListViewModel_Factory(getPokemonListUseCaseProvider);
  }

  public static PokemonListViewModel newInstance(GetPokemonListUseCase getPokemonListUseCase) {
    return new PokemonListViewModel(getPokemonListUseCase);
  }
}
