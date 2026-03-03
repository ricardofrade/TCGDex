package com.ricardofrade.tcgdex.feature.pokemonlist.data.remote;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.ktor.client.HttpClient;
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
public final class PokemonApi_Factory implements Factory<PokemonApi> {
  private final Provider<HttpClient> httpClientProvider;

  private PokemonApi_Factory(Provider<HttpClient> httpClientProvider) {
    this.httpClientProvider = httpClientProvider;
  }

  @Override
  public PokemonApi get() {
    return newInstance(httpClientProvider.get());
  }

  public static PokemonApi_Factory create(Provider<HttpClient> httpClientProvider) {
    return new PokemonApi_Factory(httpClientProvider);
  }

  public static PokemonApi newInstance(HttpClient httpClient) {
    return new PokemonApi(httpClient);
  }
}
