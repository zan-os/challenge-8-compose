package com.example.challenge.domain.model

import android.os.Parcelable
import com.example.challenge.data.local.entity.FavoriteEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val id: Int,
    val popularity: Double?,
    val posterPath: String?,
    val title: String?,
    val voteAverage: Double?,
) : Parcelable

fun Movie.toFavoriteEntity(): FavoriteEntity =
    FavoriteEntity(
        id,
        movieId = id,
        title,
        posterPath,
        popularity,
        voteAverage
    )
