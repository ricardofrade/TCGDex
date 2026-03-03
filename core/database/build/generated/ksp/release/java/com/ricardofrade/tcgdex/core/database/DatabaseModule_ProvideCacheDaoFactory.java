package com.ricardofrade.tcgdex.core.database;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
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
public final class DatabaseModule_ProvideCacheDaoFactory implements Factory<CacheDao> {
  private final Provider<TcgdexDatabase> databaseProvider;

  private DatabaseModule_ProvideCacheDaoFactory(Provider<TcgdexDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public CacheDao get() {
    return provideCacheDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideCacheDaoFactory create(
      Provider<TcgdexDatabase> databaseProvider) {
    return new DatabaseModule_ProvideCacheDaoFactory(databaseProvider);
  }

  public static CacheDao provideCacheDao(TcgdexDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideCacheDao(database));
  }
}
