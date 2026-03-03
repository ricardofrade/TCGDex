package com.ricardofrade.tcgdex.feature.pokemonlist.data.repository;

import com.ricardofrade.tcgdex.core.database.CacheDao;
import com.ricardofrade.tcgdex.feature.pokemonlist.data.remote.PokemonApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.serialization.json.Json;

@ScopeMetadata
@QualifierMetadata("com.ricardofrade.tcgdex.core.network.IoDispatcher")
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
public final class PokemonRepositoryImpl_Factory implements Factory<PokemonRepositoryImpl> {
  private final Provider<PokemonApi> apiProvider;

  private final Provider<CacheDao> cacheDaoProvider;

  private final Provider<Json> jsonProvider;

  private final Provider<CoroutineDispatcher> ioDispatcherProvider;

  private PokemonRepositoryImpl_Factory(Provider<PokemonApi> apiProvider,
      Provider<CacheDao> cacheDaoProvider, Provider<Json> jsonProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider) {
    this.apiProvider = apiProvider;
    this.cacheDaoProvider = cacheDaoProvider;
    this.jsonProvider = jsonProvider;
    this.ioDispatcherProvider = ioDispatcherProvider;
  }

  @Override
  public PokemonRepositoryImpl get() {
    return newInstance(apiProvider.get(), cacheDaoProvider.get(), jsonProvider.get(), ioDispatcherProvider.get());
  }

  public static PokemonRepositoryImpl_Factory create(Provider<PokemonApi> apiProvider,
      Provider<CacheDao> cacheDaoProvider, Provider<Json> jsonProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider) {
    return new PokemonRepositoryImpl_Factory(apiProvider, cacheDaoProvider, jsonProvider, ioDispatcherProvider);
  }

  public static PokemonRepositoryImpl newInstance(PokemonApi api, CacheDao cacheDao, Json json,
      CoroutineDispatcher ioDispatcher) {
    return new PokemonRepositoryImpl(api, cacheDao, json, ioDispatcher);
  }
}
