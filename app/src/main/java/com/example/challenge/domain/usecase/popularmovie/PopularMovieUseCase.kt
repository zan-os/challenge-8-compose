package com.example.challenge.domain.usecase.popularmovie

import android.util.Log
import com.example.challenge.data.remote.dto.toMovie
import com.example.challenge.data.resource.Resource
import com.example.challenge.domain.model.Movie
import com.example.challenge.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PopularMovieUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(): Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val movies = repository.getMovie().map { it.toMovie() }
            Log.d("photos", movies.toString())
            emit(Resource.Success(movies))
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    e.localizedMessage ?: "An unexpected error occured."
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connectivity"))
        }
    }
}