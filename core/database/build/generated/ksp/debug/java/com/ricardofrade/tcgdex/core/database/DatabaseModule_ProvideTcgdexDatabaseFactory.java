package com.ricardofrade.tcgdex.core.database;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class DatabaseModule_ProvideTcgdexDatabaseFactory implements Factory<TcgdexDatabase> {
  private final Provider<Context> contextProvider;

  private DatabaseModule_ProvideTcgdexDatabaseFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public TcgdexDatabase get() {
    return provideTcgdexDatabase(contextProvider.get());
  }

  public static DatabaseModule_ProvideTcgdexDatabaseFactory create(
      Provider<Context> contextProvider) {
    return new DatabaseModule_ProvideTcgdexDatabaseFactory(contextProvider);
  }

  public static TcgdexDatabase provideTcgdexDatabase(Context context) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideTcgdexDatabase(context));
  }
}
