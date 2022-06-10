package com.example.challenge.presentation.movie.detail.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.challenge.domain.model.Detail
import com.example.challenge.presentation.ui.theme.lightGrey

@Composable
fun Description(detail: Detail) {
    Box(modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)) {
        Column {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Overview", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
            Text(
                text = detail.overview ?: "null",
                textAlign = TextAlign.Justify,
                fontSize = 14.sp,
                color = lightGrey,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}