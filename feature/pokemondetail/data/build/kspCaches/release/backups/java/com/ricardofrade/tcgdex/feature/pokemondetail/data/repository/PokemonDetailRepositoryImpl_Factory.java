package com.ricardofrade.tcgdex.feature.pokemondetail.data.repository;

import com.ricardofrade.tcgdex.core.database.CacheDao;
import com.ricardofrade.tcgdex.feature.pokemondetail.data.remote.PokemonDetailApi;
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
public final class PokemonDetailRepositoryImpl_Factory implements Factory<PokemonDetailRepositoryImpl> {
  private final Provider<PokemonDetailApi> apiProvider;

  private final Provider<CacheDao> cacheDaoProvider;

  private final Provider<Json> jsonProvider;

  private final Provider<CoroutineDispatcher> ioDispatcherProvider;

  private PokemonDetailRepositoryImpl_Factory(Provider<PokemonDetailApi> apiProvider,
      Provider<CacheDao> cacheDaoProvider, Provider<Json> jsonProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider) {
    this.apiProvider = apiProvider;
    this.cacheDaoProvider = cacheDaoProvider;
    this.jsonProvider = jsonProvider;
    this.ioDispatcherProvider = ioDispatcherProvider;
  }

  @Override
  public PokemonDetailRepositoryImpl get() {
    return newInstance(apiProvider.get(), cacheDaoProvider.get(), jsonProvider.get(), ioDispatcherProvider.get());
  }

  public static PokemonDetailRepositoryImpl_Factory create(Provider<PokemonDetailApi> apiProvider,
      Provider<CacheDao> cacheDaoProvider, Provider<Json> jsonProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider) {
    return new PokemonDetailRepositoryImpl_Factory(apiProvider, cacheDaoProvider, jsonProvider, ioDispatcherProvider);
  }

  public static PokemonDetailRepositoryImpl newInstance(PokemonDetailApi api, CacheDao cacheDao,
      Json json, CoroutineDispatcher ioDispatcher) {
    return new PokemonDetailRepositoryImpl(api, cacheDao, json, ioDispatcher);
  }
}
