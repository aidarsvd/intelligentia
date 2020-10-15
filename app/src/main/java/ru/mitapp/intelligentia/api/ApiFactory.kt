package ru.mitapp.intelligentia.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private lateinit var retrofit : Retrofit
    var apiInterface : RestApi? = null

    fun getRetrofit(): Retrofit{
        retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }

    fun getRetrofit1(): Retrofit{
        retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }





}