package com.example.challenge.presentation.movie.search.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.challenge.presentation.movie.search.SearchMovieViewModel
import com.example.challenge.presentation.ui.theme.grey

@Composable
fun TopBar(viewModel: SearchMovieViewModel = hiltViewModel()) {
    var queryText by rememberSaveable { mutableStateOf("") }
    Box {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .clip(shape = RoundedCornerShape(bottomEnd = 50.dp, bottomStart = 50.dp))
                .background(grey)
        )
        Row(
            modifier = Modifier
                .padding(16.dp)
                .height(50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            TextField(
                value = queryText,
                onValueChange = {
                    queryText = it;
                    if (queryText.isNotEmpty())
                        viewModel.searchMovies(queryText)
                },
                placeholder = { Text(text = "Search for movie", fontSize = 14.sp) },
                singleLine = true,
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") },
                textStyle = TextStyle(fontSize = 14.sp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    textColor = Color.Black
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}
