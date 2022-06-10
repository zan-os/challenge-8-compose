package com.example.challenge.presentation.movie.favorite

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.challenge.presentation.movie.componenets.MovieListItem
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
fun FavoriteScreen(
    viewModel: FavoriteViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {
    val state = viewModel.state.value
    LazyColumn() {
        items(state.movies) { movie ->
            MovieListItem(
                movie = movie,
                navigator
            )
        }
    }
}