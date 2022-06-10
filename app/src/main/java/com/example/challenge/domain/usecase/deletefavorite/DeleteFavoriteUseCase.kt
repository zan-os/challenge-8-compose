package com.example.challenge.domain.usecase.deletefavorite

import com.example.challenge.data.resource.Resource
import com.example.challenge.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DeleteFavoriteUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(movieId: Int?): Flow<Resource<Unit>> = flow {
        try {
            emit(Resource.Loading())
            val movie = repository.deleteFavoriteMovie(movieId)
            emit(Resource.Success(movie))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        }
    }
}