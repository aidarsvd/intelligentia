package ru.mitapp.intelligentia.models

import com.google.gson.annotations.SerializedName

data class WeatherWindData (
    @SerializedName("speed") var speed: String? = null,
    @SerializedName("deg") var deg: String? = null
)