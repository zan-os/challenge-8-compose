package com.example.challenge.domain.usecase.observefavoritebyid

import com.example.challenge.data.resource.Resource
import com.example.challenge.domain.model.Favorite
import com.example.challenge.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ObserveFavoriteUseByIdCaseById @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke( movieId: Int): Flow<Resource<Favorite?>> = flow {
        try {
            emit(Resource.Loading())
            val movie = repository.observeFavoriteMovieById(movieId)
            emit(Resource.Success(movie))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        }
    }
}