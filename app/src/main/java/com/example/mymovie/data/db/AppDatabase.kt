package com.example.mymovie.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mymovie.domain.model.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
}