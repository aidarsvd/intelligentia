package ru.mitapp.intelligentia.models

import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("main") var main : String? = null,
    @SerializedName("description") var description : String? = null
)