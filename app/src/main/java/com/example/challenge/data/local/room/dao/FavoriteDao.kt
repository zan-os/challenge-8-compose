package com.example.challenge.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.challenge.data.local.entity.FavoriteEntity

@Dao
interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavoriteMovie(movie: FavoriteEntity)

    @Query("SELECT * FROM favorite_movies ")
    suspend fun observerFavoriteMovie(): List<FavoriteEntity>

    @Query("SELECT * FROM favorite_movies WHERE movie_id = :movieId")
    suspend fun observeFavoriteMovieById(movieId: Int?): FavoriteEntity?

    @Query("DELETE FROM favorite_movies WHERE movie_id = :movieId")
    suspend fun removeFavoriteMovie(movieId: Int?)
}