package com.ricardofrade.tcgdex.feature.pokemonlist.domain.usecase;

import com.ricardofrade.tcgdex.feature.pokemonlist.domain.repository.PokemonRepository;
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
public final class GetPokemonListUseCaseImpl_Factory implements Factory<GetPokemonListUseCaseImpl> {
  private final Provider<PokemonRepository> repositoryProvider;

  private GetPokemonListUseCaseImpl_Factory(Provider<PokemonRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetPokemonListUseCaseImpl get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetPokemonListUseCaseImpl_Factory create(
      Provider<PokemonRepository> repositoryProvider) {
    return new GetPokemonListUseCaseImpl_Factory(repositoryProvider);
  }

  public static GetPokemonListUseCaseImpl newInstance(PokemonRepository repository) {
    return new GetPokemonListUseCaseImpl(repository);
  }
}
