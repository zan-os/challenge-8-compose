package com.example.challenge.data.remote

import com.example.challenge.data.remote.dto.DetailDto
import com.example.challenge.data.remote.dto.ResultDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheMovieApi {
    @GET("movie/popular")
    suspend fun getMovies(
        @Query("api_key") apiKey: String
    ): ResultDto

    @GET("movie/{movie_id}")
    suspend fun getMovieById(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String
    ): DetailDto

    @GET("search/movie/")
    suspend fun searchMovie(
        @Query("api_key") apiKey: String,
        @Query("query") query: String
    ): ResultDto
}