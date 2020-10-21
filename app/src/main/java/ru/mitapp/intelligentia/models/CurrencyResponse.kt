package ru.mitapp.intelligentia.models

import com.google.gson.annotations.SerializedName
import ru.mitapp.intelligentia.fragments.CurrencyFragment




data class CurrencyResponse (

    @SerializedName("USD_USD") var currency: String
)