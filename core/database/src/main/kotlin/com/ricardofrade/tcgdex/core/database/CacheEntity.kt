package com.ricardofrade.tcgdex.core.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cache")
data class CacheEntity(
    @PrimaryKey
    val key: String,
    val payload: String,
    val timestamp: Long
)
