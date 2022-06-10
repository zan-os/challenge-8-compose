package com.example.challenge.utils
import com.example.challenge.domain.model.Movie

data class MovieState(
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: String = ""
)