package ru.mitapp.intelligentia.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiFactory {

    private lateinit var retrofit : Retrofit

    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    var client = OkHttpClient.Builder().addInterceptor(logger).build()


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
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit
    }


    fun getRetrofit2(): Retrofit{
        retrofit = Retrofit.Builder()
            .baseUrl("https://free.currconv.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit
    }








}