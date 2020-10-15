package ru.mitapp.intelligentia.models

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class NewsResponse(
    @SerializedName("status") var status : String? = null,
    @SerializedName("totalResults")  var totalResults : Int? = null,
    @SerializedName("articles")  var articles : ArrayList<News>? = null
)