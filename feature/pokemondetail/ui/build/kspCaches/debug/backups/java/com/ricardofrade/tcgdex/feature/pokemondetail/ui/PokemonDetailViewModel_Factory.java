package com.ricardofrade.tcgdex.feature.pokemondetail.ui;

import com.ricardofrade.tcgdex.feature.pokemondetail.domain.usecase.GetPokemonDetailUseCase;
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
public final class PokemonDetailViewModel_Factory implements Factory<PokemonDetailViewModel> {
  private final Provider<GetPokemonDetailUseCase> getPokemonDetailUseCaseProvider;

  private PokemonDetailViewModel_Factory(
      Provider<GetPokemonDetailUseCase> getPokemonDetailUseCaseProvider) {
    this.getPokemonDetailUseCaseProvider = getPokemonDetailUseCaseProvider;
  }

  @Override
  public PokemonDetailViewModel get() {
    return newInstance(getPokemonDetailUseCaseProvider.get());
  }

  public static PokemonDetailViewModel_Factory create(
      Provider<GetPokemonDetailUseCase> getPokemonDetailUseCaseProvider) {
    return new PokemonDetailViewModel_Factory(getPokemonDetailUseCaseProvider);
  }

  public static PokemonDetailViewModel newInstance(
      GetPokemonDetailUseCase getPokemonDetailUseCase) {
    return new PokemonDetailViewModel(getPokemonDetailUseCase);
  }
}
