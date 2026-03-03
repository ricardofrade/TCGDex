package com.ricardofrade.tcgdex.feature.pokemondetail.data.remote;

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
public final class PokemonDetailApi_Factory implements Factory<PokemonDetailApi> {
  private final Provider<HttpClient> httpClientProvider;

  private PokemonDetailApi_Factory(Provider<HttpClient> httpClientProvider) {
    this.httpClientProvider = httpClientProvider;
  }

  @Override
  public PokemonDetailApi get() {
    return newInstance(httpClientProvider.get());
  }

  public static PokemonDetailApi_Factory create(Provider<HttpClient> httpClientProvider) {
    return new PokemonDetailApi_Factory(httpClientProvider);
  }

  public static PokemonDetailApi newInstance(HttpClient httpClient) {
    return new PokemonDetailApi(httpClient);
  }
}
