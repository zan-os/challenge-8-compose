package com.example.challenge.presentation.movie.detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.challenge.domain.model.Detail
import com.example.challenge.utils.Extensions.baseImageUrl

@Composable
fun Poster(detail: Detail) {
    Box(
        modifier = Modifier
            .blur(100.dp)
            .height(300.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = detail.backdropPath?.baseImageUrl()),
            contentDescription = detail.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}