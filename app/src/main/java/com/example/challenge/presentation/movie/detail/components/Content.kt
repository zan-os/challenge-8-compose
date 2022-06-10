package com.example.challenge.presentation.movie.detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.challenge.domain.model.Detail
import com.example.challenge.presentation.ui.theme.grey
import com.example.challenge.presentation.ui.theme.orange
import com.example.challenge.utils.Extensions.baseImageUrl

@Composable
fun Content(detail: Detail) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .offset(y = (100).dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .offset(y = 50.dp)
                .background(grey)
                .clip(RoundedCornerShape(8.dp))
        )
        Column(
            modifier = Modifier
                .align(Alignment.TopStart)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = detail.posterPath.baseImageUrl()),
                    contentDescription = null,
                    modifier = Modifier
                        .height(180.dp)
                        .width(120.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .border(1.dp, orange)
                )
                Text(
                    text = detail.title ?: "null",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = orange,
                    modifier = Modifier.padding(top = 66.dp, start = 8.dp)
                )
            }
            Description(detail = detail)
        }
    }
}