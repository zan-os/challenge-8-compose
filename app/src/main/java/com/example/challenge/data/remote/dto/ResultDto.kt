package com.example.challenge.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ResultDto(
    @SerializedName("results")
    val result: List<MovieDto>
)
