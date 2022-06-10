package com.example.challenge.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.challenge.presentation.movie.destinations.FavoriteScreenDestination
import com.example.challenge.presentation.movie.destinations.PopularScreenDestination
import com.example.challenge.presentation.movie.destinations.SearchScreenDestination
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec

enum class BottomBarDestination(
    val direction: DirectionDestinationSpec,
    val icon: ImageVector,
    val label: String
) {
    MovieList(PopularScreenDestination, Icons.Default.Star, "Popular"),
    Search(SearchScreenDestination, Icons.Default.Search, "Search"),
    Favorite(FavoriteScreenDestination, Icons.Default.Favorite, "Favorite")
}