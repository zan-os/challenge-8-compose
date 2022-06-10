package com.example.challenge.presentation.movie.componenets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.challenge.domain.model.Movie
import com.example.challenge.presentation.movie.destinations.DetailMovieScreenDestination
import com.example.challenge.presentation.ui.theme.grey
import com.example.challenge.presentation.ui.theme.orange
import com.example.challenge.utils.Extensions.baseImageUrl
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun MovieListItem(movie: Movie, navigator: DestinationsNavigator) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
            .padding(16.dp)
            .clickable { navigator.navigate(DetailMovieScreenDestination(movie.id)) }
    ) {
        Box(
            modifier = Modifier
                .height(170.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(grey)
                .align(Alignment.BottomCenter)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopStart)
                .padding(start = 20.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = movie.posterPath?.baseImageUrl()),
                contentDescription = null,
                modifier = Modifier
                    .height(180.dp)
                    .width(120.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .border(1.dp, orange)
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(top = 48.dp, bottom = 16.dp, start = 16.dp)
            ) {
                Text(
                    text = "${movie.title}",
                    modifier = Modifier.padding(bottom = 8.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = orange
                )
                Text(text = "Genres", color = Color.White)
                Text(text = "Authors.", color = Color.White)
                Text(
                    text = "${movie.voteAverage} IMDb",
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color.White
                )
            }
        }
    }
}
