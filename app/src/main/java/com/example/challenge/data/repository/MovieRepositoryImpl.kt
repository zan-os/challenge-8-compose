package com.example.challenge.data.repository

import com.example.challenge.BuildConfig
import com.example.challenge.data.local.entity.FavoriteEntity
import com.example.challenge.data.local.entity.toFavorite
import com.example.challenge.data.local.room.dao.FavoriteDao
import com.example.challenge.data.remote.TheMovieApi
import com.example.challenge.data.remote.dto.DetailDto
import com.example.challenge.data.remote.dto.MovieDto
import com.example.challenge.domain.model.Favorite
import com.example.challenge.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: TheMovieApi,
    private val favoriteDao: FavoriteDao
) : MovieRepository {

    override suspend fun getMovie(): List<MovieDto> {
        return api.getMovies(BuildConfig.API_KEY).result
    }

    override suspend fun getMovieById(movieId: Int): DetailDto {
        return api.getMovieById(movieId, BuildConfig.API_KEY)
    }

    override suspend fun searchMovie(query: String): List<MovieDto> {
        return api.searchMovie(BuildConfig.API_KEY, query).result
    }

    override suspend fun addFavoriteMovie(movie: FavoriteEntity) {
        return favoriteDao.addFavoriteMovie(movie)
    }

    override suspend fun deleteFavoriteMovie(movieId: Int?) {
        return favoriteDao.removeFavoriteMovie(movieId)
    }

    override suspend fun observeFavoriteMovieById(movieId: Int): Favorite? {
        return favoriteDao.observeFavoriteMovieById(movieId)?.toFavorite()
    }

    override suspend fun observeFavoriteMovie(): List<FavoriteEntity> {
        return favoriteDao.observerFavoriteMovie()
    }

}