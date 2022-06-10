package com.example.challenge.presentation.movie.detail

import com.example.challenge.domain.model.Detail
import com.example.challenge.domain.model.Favorite


data class DetailState(
    val isLoading: Boolean = false,
    val movie: Detail? = null,
    val error: String = "",
    val favoriteMovies: Favorite? = null
)