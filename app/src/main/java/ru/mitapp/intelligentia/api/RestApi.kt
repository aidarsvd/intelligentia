package ru.mitapp.intelligentia.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import ru.mitapp.intelligentia.models.CurrencyResponse
import ru.mitapp.intelligentia.models.NewsResponse
import ru.mitapp.intelligentia.models.WeatherResponse

interface RestApi {



    @GET("v2/top-headlines")
    fun getNews(@Query("apiKey") apiKey : String, @Query("country") country : String) : Call<NewsResponse>

    @GET("data/2.5/weather")
    fun getWeather(@Query("q") q : String, @Query("appid") appid : String) : Call<WeatherResponse>


    @GET("api-v2/forex/latest")
    fun getCurrency(@Query("symbol", encoded = true) symbol : String, @Query("access_key") access_key : String) : Call<CurrencyResponse>

}
