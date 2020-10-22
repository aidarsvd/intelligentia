package ru.mitapp.intelligentia.models

import com.google.gson.annotations.SerializedName

data class CurrencyResponseInfo (
    @SerializedName("server_time") var server_time: String,
    @SerializedName("credit_count") var credit_count: String,
    @SerializedName("_t") var _t: String
)