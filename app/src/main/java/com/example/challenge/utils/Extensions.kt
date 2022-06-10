package com.example.challenge.utils

import com.example.challenge.BuildConfig

object Extensions {

    fun String.baseImageUrl(): String {
        return BuildConfig.BASE_IMAGE_URL + this
    }
}