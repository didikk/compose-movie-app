package com.example.mymovie.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.mymovie.domain.model.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {
    @Query("SELECT * FROM favorite")
    fun getAll(): Flow<List<Movie>>

    @Query("SELECT EXISTS(SELECT * FROM favorite WHERE id = :id)")
    fun isFavorite(id: Int): Flow<Boolean>

    @Insert
    suspend fun insert(movie: Movie)

    @Delete
    suspend fun delete(movie: Movie)
}