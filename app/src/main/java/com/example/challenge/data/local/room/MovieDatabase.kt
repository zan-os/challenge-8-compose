package com.example.challenge.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.challenge.data.local.entity.FavoriteEntity
import com.example.challenge.data.local.room.dao.FavoriteDao

@Database(entities = [FavoriteEntity::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
}