package ru.mitapp.intelligentia.models

import com.google.gson.annotations.SerializedName

data class WeatherResponse (
    @SerializedName("weather") var weather :ArrayList<Weather>? = null,
    @SerializedName("main") var main: WeatherMainData? = null,
    @SerializedName("wind") var wind: WeatherWindData? = null,
    @SerializedName("visibility") var visibility: String?,
    @SerializedName("name") var name: String?

)