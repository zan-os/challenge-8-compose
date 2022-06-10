package com.example.challenge.data.remote.dto

import com.example.challenge.domain.model.Detail
import com.google.gson.annotations.SerializedName

data class DetailDto(
    @field:SerializedName("original_language")
    val originalLanguage: String,

    @field:SerializedName("imdb_id")
    val imdbId: String? = null,

    @field:SerializedName("video")
    val video: Boolean? = null,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("backdrop_path")
    val backdropPath: String,

    @field:SerializedName("revenue")
    val revenue: Int? = null,

    @field:SerializedName("popularity")
    val popularity: Double,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("vote_count")
    val voteCount: Int? = null,

    @field:SerializedName("budget")
    val budget: Int? = null,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("original_title")
    val originalTitle: String,

    @field:SerializedName("runtime")
    val runtime: Int,

    @field:SerializedName("poster_path")
    val posterPath: String,

    @field:SerializedName("release_date")
    val releaseDate: String,

    @field:SerializedName("vote_average")
    val voteAverage: Double,

    @field:SerializedName("belongs_to_collection")
    val belongsToCollection: Any? = null,

    @field:SerializedName("tagline")
    val tagline: String? = null,

    @field:SerializedName("adult")
    val adult: Boolean? = null,

    @field:SerializedName("homepage")
    val homepage: String? = null,

    @field:SerializedName("status")
    val status: String? = null
)

fun DetailDto.toDetail(): Detail =
    Detail(
        id,
        backdropPath,
        originalLanguage,
        originalTitle,
        overview,
        popularity,
        posterPath,
        releaseDate,
        runtime,
        title,
        voteAverage
    )