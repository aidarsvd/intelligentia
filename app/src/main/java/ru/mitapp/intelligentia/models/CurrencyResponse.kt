package ru.mitapp.intelligentia.models

import com.google.gson.annotations.SerializedName
import ru.mitapp.intelligentia.fragments.CurrencyFragment




data class CurrencyResponse (

    @SerializedName("status") var status: Boolean,
    @SerializedName("code") var code: Int,
    @SerializedName("msg") var msg: String,
    @SerializedName("response") var response: ArrayList<Currency>,
    @SerializedName("info") var info: CurrencyResponseInfo

)