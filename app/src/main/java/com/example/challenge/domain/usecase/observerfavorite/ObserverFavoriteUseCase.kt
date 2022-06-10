package com.example.challenge.domain.usecase.observerfavorite

import com.example.challenge.data.local.entity.toMovie
import com.example.challenge.data.resource.Resource
import com.example.challenge.domain.model.Movie
import com.example.challenge.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ObserveFavoriteMovieUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(): Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val movie = repository.observeFavoriteMovie().map { it.toMovie() }
            emit(Resource.Success(movie))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        }
    }
}