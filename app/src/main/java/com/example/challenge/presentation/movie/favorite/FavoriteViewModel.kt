package com.example.challenge.presentation.movie.favorite

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challenge.data.resource.Resource
import com.example.challenge.domain.usecase.observerfavorite.ObserveFavoriteMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val useCase: ObserveFavoriteMovieUseCase
) : ViewModel() {

    private var _state = mutableStateOf(FavoriteState())
    val state: State<FavoriteState> = _state

    init {
        getMovie()
    }

    private fun getMovie() {
        useCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = FavoriteState(movies = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value =
                        FavoriteState(
                            error = result.message ?: "An unexpected error occured"
                        )
                }
                is Resource.Loading -> {
                    _state.value = FavoriteState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}