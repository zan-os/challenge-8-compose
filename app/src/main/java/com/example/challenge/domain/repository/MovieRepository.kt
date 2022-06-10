package com.example.challenge.domain.repository

import com.example.challenge.data.local.entity.FavoriteEntity
import com.example.challenge.data.remote.dto.DetailDto
import com.example.challenge.data.remote.dto.MovieDto
import com.example.challenge.domain.model.Favorite

interface MovieRepository {

    suspend fun getMovie(): List<MovieDto>

    suspend fun getMovieById(movieId: Int): DetailDto

    suspend fun searchMovie(query: String): List<MovieDto>

    suspend fun addFavoriteMovie(movie: FavoriteEntity)

    suspend fun deleteFavoriteMovie(movieId: Int?)

    suspend fun observeFavoriteMovieById(movieId: Int): Favorite?

    suspend fun observeFavoriteMovie(): List<FavoriteEntity>
}