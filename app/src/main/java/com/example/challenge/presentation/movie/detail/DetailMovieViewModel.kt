package com.example.challenge.presentation.movie.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.example.challenge.data.resource.Resource
import com.example.challenge.domain.model.Favorite
import com.example.challenge.domain.model.Movie
import com.example.challenge.domain.usecase.addfavorite.AddFavoriteUseCase
import com.example.challenge.domain.usecase.deletefavorite.DeleteFavoriteUseCase
import com.example.challenge.domain.usecase.detailmovie.DetailMovieUseCase
import com.example.challenge.domain.usecase.observefavoritebyid.ObserveFavoriteUseByIdCaseById
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailMovieViewModel @Inject constructor(
    private val detailUseCase: DetailMovieUseCase,
    private val addFavoriteUseCase: AddFavoriteUseCase,
    private val observeFavoriteUseByIdCaseById: ObserveFavoriteUseByIdCaseById,
    private val deleteFavoriteUseCase: DeleteFavoriteUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var _state = mutableStateOf(DetailState())
    val state: State<DetailState> = _state

    private val _favoriteMovie = MutableLiveData<Favorite?>()
    val favoriteMovie: LiveData<Favorite?> = _favoriteMovie

    private val movieId = savedStateHandle.get<Int>("movieId")

    init {
        movieId?.let {
            getMovieById(it)
            observeFavoriteMovie(it)
        }
    }

    private fun getMovieById(movieId: Int) {
        detailUseCase(movieId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = DetailState(movie = result.data)
                }
                is Resource.Error -> {
                    _state.value =
                        DetailState(
                            error = result.message ?: "An unexpected error occured"
                        )
                }
                is Resource.Loading -> {
                    _state.value = DetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun addFavoriteMovie(movie: Movie) {
        addFavoriteUseCase(movie).launchIn(viewModelScope)
    }

    private fun observeFavoriteMovie(movieId: Int) {
        observeFavoriteUseByIdCaseById(movieId).onEach { result ->
            when (result) {
                is Resource.Success -> {
//                    DetailState(favoriteMovies = result.data)
                    _favoriteMovie.value = result.data
                }
                is Resource.Error -> {
                    _state.value =
                        DetailState(
                            error = result.message ?: "An unexpected error occured"
                        )
                }
                is Resource.Loading -> {
                    _state.value = DetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun deleteFavoriteMovie(movieId: Int?) {
        deleteFavoriteUseCase(movieId).launchIn(viewModelScope)
    }
}