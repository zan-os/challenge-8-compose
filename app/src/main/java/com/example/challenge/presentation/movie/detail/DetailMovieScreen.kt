package com.example.challenge.presentation.movie.detail

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.challenge.domain.model.Detail
import com.example.challenge.domain.model.toMovie
import com.example.challenge.presentation.movie.detail.components.Content
import com.example.challenge.presentation.movie.detail.components.Poster
import com.example.challenge.presentation.ui.theme.black
import com.ramcosta.composedestinations.annotation.Destination

@Composable
@Destination
fun DetailMovieScreen(
    movieId: Int,
    viewModel: DetailMovieViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val context = LocalContext.current
    Scaffold(
        backgroundColor = black
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            state.movie?.let { detail ->
                Box(modifier = Modifier.fillMaxSize()) {
                    Poster(detail = detail)
                    Content(detail = detail)
                    TopBar(detail = detail, context)
                }
                if (state.error.isNotEmpty()) {
                    Text(
                        text = state.error,
                        color = MaterialTheme.colors.error,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
                if (state.isLoading) {
                    CircularProgressIndicator(modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }
}

@Composable
fun TopBar(detail: Detail, context: Context, viewModel: DetailMovieViewModel = hiltViewModel()) {
    val favoriteState = viewModel.favoriteMovie.observeAsState().value
    Log.d("Movies", favoriteState.toString())
    Row(
        horizontalArrangement = Arrangement.End,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        if (favoriteState == null) {
            IconButton(onClick = {
                viewModel.addFavoriteMovie(detail.toMovie())
                Toast.makeText(context,"Berhasil menambahkan favorite", Toast.LENGTH_LONG).show()
            }) {
                Icon(Icons.Default.Favorite, contentDescription = null)
            }
        } else {
            IconButton(onClick = {
                viewModel.deleteFavoriteMovie(detail.id)
                Toast.makeText(context,"Berhasil menghapus favorite", Toast.LENGTH_LONG).show()
            }) {
                Icon(Icons.Default.Favorite, contentDescription = null, tint = Color.Red)
            }
        }
    }

}