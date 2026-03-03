package com.ricardofrade.tcgdex.feature.pokemondetail.domain.usecase;

import com.ricardofrade.tcgdex.feature.pokemondetail.domain.repository.PokemonDetailRepository;
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
public final class GetPokemonDetailUseCaseImpl_Factory implements Factory<GetPokemonDetailUseCaseImpl> {
  private final Provider<PokemonDetailRepository> repositoryProvider;

  private GetPokemonDetailUseCaseImpl_Factory(
      Provider<PokemonDetailRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetPokemonDetailUseCaseImpl get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetPokemonDetailUseCaseImpl_Factory create(
      Provider<PokemonDetailRepository> repositoryProvider) {
    return new GetPokemonDetailUseCaseImpl_Factory(repositoryProvider);
  }

  public static GetPokemonDetailUseCaseImpl newInstance(PokemonDetailRepository repository) {
    return new GetPokemonDetailUseCaseImpl(repository);
  }
}
