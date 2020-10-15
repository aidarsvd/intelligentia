package ru.mitapp.intelligentia.models

import com.google.gson.annotations.SerializedName

data class WeatherMainData(
    @SerializedName("temp") var temp : String? = null,
    @SerializedName("feels_like") var feels_like : String? = null,
    @SerializedName("pressure") var pressure : String? = null,
    @SerializedName("pressure") var humidity : String? = null

)