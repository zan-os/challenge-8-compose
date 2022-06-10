package com.example.challenge.domain.usecase.detailmovie

import com.example.challenge.data.remote.dto.toDetail
import com.example.challenge.data.resource.Resource
import com.example.challenge.domain.model.Detail
import com.example.challenge.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DetailMovieUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(movieId: Int): Flow<Resource<Detail>> = flow {
        try {
            emit(Resource.Loading())
            val movie = repository.getMovieById(movieId).toDetail()
            emit(Resource.Success(movie))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured."))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connectivity"))
        }
    }
}