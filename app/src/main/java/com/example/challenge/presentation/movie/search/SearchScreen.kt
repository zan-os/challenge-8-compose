package com.example.challenge.presentation.movie.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.challenge.presentation.movie.componenets.MovieListItem
import com.example.challenge.presentation.movie.search.components.TopBar
import com.example.challenge.presentation.ui.theme.black
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun SearchScreen(
    viewModel: SearchMovieViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {
    val state = viewModel.state.value
    Scaffold(
        topBar = { TopBar() },
        backgroundColor = black
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier.fillMaxHeight()) {
                LazyColumn() {
                    items(state.movies) { movie ->
                        MovieListItem(
                            movie = movie,
                            navigator
                        )
                    }
                }
                if (state.error.isNotEmpty()) {
                    Text(
                        text = state.error,
                        color = MaterialTheme.colors.error,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center)
                    )
                }
                if (state.isLoading) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}