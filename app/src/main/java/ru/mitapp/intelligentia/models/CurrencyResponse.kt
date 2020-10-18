package ru.mitapp.intelligentia.models

import com.google.gson.annotations.SerializedName
import ru.mitapp.intelligentia.fragments.CurrencyFragment
import ru.mitapp.intelligentia.utils.PreferencesUtils



data class CurrencyResponse (

    @SerializedName("USD_KGS") var currency: String
)