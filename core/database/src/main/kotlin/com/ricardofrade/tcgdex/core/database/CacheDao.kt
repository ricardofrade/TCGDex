package com.ricardofrade.tcgdex.core.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CacheDao {
    @Query("SELECT * FROM cache WHERE `key` = :key")
    fun getCache(key: String): CacheEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCache(cacheEntity: CacheEntity)

    @Query("DELETE FROM cache")
    fun clearCache()

    @Query("DELETE FROM cache WHERE `key` = :key")
    fun deleteCache(key: String)
}
