package com.ricardofrade.tcgdex.core.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CacheEntity::class], version = 1, exportSchema = false)
abstract class TcgdexDatabase : RoomDatabase() {
    abstract fun cacheDao(): CacheDao
}
