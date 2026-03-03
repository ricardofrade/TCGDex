package com.ricardofrade.tcgdex.core.network;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.ktor.client.HttpClient;
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
public final class NetworkModule_ProvideKtorClientFactory implements Factory<HttpClient> {
  @Override
  public HttpClient get() {
    return provideKtorClient();
  }

  public static NetworkModule_ProvideKtorClientFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static HttpClient provideKtorClient() {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideKtorClient());
  }

  private static final class InstanceHolder {
    static final NetworkModule_ProvideKtorClientFactory INSTANCE = new NetworkModule_ProvideKtorClientFactory();
  }
}
