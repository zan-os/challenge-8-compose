@file:Suppress("SpellCheckingInspection"
)

package com.example.challenge.domain.usecase.addfavorite

import com.example.challenge.data.resource.Resource
import com.example.challenge.domain.model.Movie
import com.example.challenge.domain.model.toFavoriteEntity
import com.example.challenge.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AddFavoriteUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(movie: Movie): Flow<Resource<Unit>> = flow {
        try {
            emit(Resource.Loading())
            val favoriteEntity = movie.toFavoriteEntity()
            val data = repository.addFavoriteMovie(favoriteEntity)
            emit(Resource.Success(data))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        }
    }

}