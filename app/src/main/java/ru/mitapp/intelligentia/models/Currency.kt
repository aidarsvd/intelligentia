package ru.mitapp.intelligentia.models

import com.google.gson.annotations.SerializedName

data class Currency (
    @SerializedName("id") var id: String,
    @SerializedName("price") var price: String,
    @SerializedName("change") var change: String,
    @SerializedName("chg_per") var chg_per: String,
    @SerializedName("last_changed") var last_changed: String,
    @SerializedName("symbol") var symbol: String
)