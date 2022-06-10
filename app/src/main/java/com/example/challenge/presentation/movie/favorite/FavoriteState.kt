package com.example.challenge.presentation.movie.favorite

import com.example.challenge.domain.model.Movie

data class FavoriteState(
    val isLoading: Boolean = false,
    val error: String = "",
    val movies: List<Movie> = emptyList()
)