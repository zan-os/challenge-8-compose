package com.example.challenge.presentation.movie.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challenge.data.resource.Resource
import com.example.challenge.domain.usecase.searchmovie.SearchMovieUseCase
import com.example.challenge.utils.MovieState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SearchMovieViewModel @Inject constructor(
    private val useCase: SearchMovieUseCase
) : ViewModel() {
    private var _state = mutableStateOf(MovieState())
    val state: State<MovieState> = _state

    fun searchMovies(query: String) {
        useCase(query).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = MovieState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = MovieState(movies = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value =
                        MovieState(error = result.message ?: "An unexpected error occured")
                }
            }
        }.launchIn(viewModelScope)
    }
}