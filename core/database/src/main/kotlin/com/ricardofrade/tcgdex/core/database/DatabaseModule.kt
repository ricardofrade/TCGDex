package com.ricardofrade.tcgdex.core.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideTcgdexDatabase(@ApplicationContext context: Context): TcgdexDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = TcgdexDatabase::class.java,
            name = "tcgdex_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideCacheDao(database: TcgdexDatabase): CacheDao {
        return database.cacheDao()
    }
}
