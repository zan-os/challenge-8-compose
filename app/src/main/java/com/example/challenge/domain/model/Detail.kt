package com.example.challenge.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Detail(
    val id: Int,
    val backdropPath: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val runtime: Int,
    val title: String?,
    val voteAverage: Double,
) : Parcelable

fun Detail.toMovie(): Movie =
    Movie(id, popularity, posterPath, title, voteAverage)