package com.example.mymovie.di

import android.content.Context
import androidx.room.Room
import com.example.mymovie.data.db.AppDatabase
import org.koin.dsl.module

val appModule = module {
    single { createAppDatabase(get()) }
    single { createFavoriteDao(get()) }
}

private fun createAppDatabase(context: Context): AppDatabase {
    return Room
        .databaseBuilder(context, AppDatabase::class.java, "movie_database")
        .build()
}

private fun createFavoriteDao(appDatabase: AppDatabase) = appDatabase.favoriteDao()