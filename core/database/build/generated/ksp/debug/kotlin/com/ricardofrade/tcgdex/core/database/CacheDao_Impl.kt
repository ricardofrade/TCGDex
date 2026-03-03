package com.ricardofrade.tcgdex.core.database

import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performBlocking
import androidx.sqlite.SQLiteStatement
import javax.`annotation`.processing.Generated
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.reflect.KClass

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class CacheDao_Impl(
  __db: RoomDatabase,
) : CacheDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfCacheEntity: EntityInsertAdapter<CacheEntity>
  init {
    this.__db = __db
    this.__insertAdapterOfCacheEntity = object : EntityInsertAdapter<CacheEntity>() {
      protected override fun createQuery(): String = "INSERT OR REPLACE INTO `cache` (`key`,`payload`,`timestamp`) VALUES (?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: CacheEntity) {
        statement.bindText(1, entity.key)
        statement.bindText(2, entity.payload)
        statement.bindLong(3, entity.timestamp)
      }
    }
  }

  public override fun insertCache(cacheEntity: CacheEntity): Unit = performBlocking(__db, false, true) { _connection ->
    __insertAdapterOfCacheEntity.insert(_connection, cacheEntity)
  }

  public override fun getCache(key: String): CacheEntity? {
    val _sql: String = "SELECT * FROM cache WHERE `key` = ?"
    return performBlocking(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, key)
        val _columnIndexOfKey: Int = getColumnIndexOrThrow(_stmt, "key")
        val _columnIndexOfPayload: Int = getColumnIndexOrThrow(_stmt, "payload")
        val _columnIndexOfTimestamp: Int = getColumnIndexOrThrow(_stmt, "timestamp")
        val _result: CacheEntity?
        if (_stmt.step()) {
          val _tmpKey: String
          _tmpKey = _stmt.getText(_columnIndexOfKey)
          val _tmpPayload: String
          _tmpPayload = _stmt.getText(_columnIndexOfPayload)
          val _tmpTimestamp: Long
          _tmpTimestamp = _stmt.getLong(_columnIndexOfTimestamp)
          _result = CacheEntity(_tmpKey,_tmpPayload,_tmpTimestamp)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun clearCache() {
    val _sql: String = "DELETE FROM cache"
    return performBlocking(__db, false, true) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        _stmt.step()
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun deleteCache(key: String) {
    val _sql: String = "DELETE FROM cache WHERE `key` = ?"
    return performBlocking(__db, false, true) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, key)
        _stmt.step()
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
