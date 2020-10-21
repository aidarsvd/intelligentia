package ru.mitapp.intelligentia.models

import com.google.gson.annotations.SerializedName

data class WeatherMainData(
    @SerializedName("temp") var temp: Double,
    @SerializedName("feels_like") var feels_like: Double,
    @SerializedName("temp_min") var temp_min: String? = null,
    @SerializedName("temp_max") var temp_max: String? = null,
    @SerializedName("pressure") var pressure: String? = null,
    @SerializedName("humidity") var humidity: String? = null

)