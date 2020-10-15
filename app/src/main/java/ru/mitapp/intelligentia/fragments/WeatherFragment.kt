package ru.mitapp.intelligentia.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import ru.mitapp.intelligentia.R
import ru.mitapp.intelligentia.adapters.NewsAdapter
import ru.mitapp.intelligentia.api.ApiFactory
import ru.mitapp.intelligentia.api.RestApi
import ru.mitapp.intelligentia.models.NewsResponse
import ru.mitapp.intelligentia.models.WeatherResponse
import ru.mitapp.intelligentia.viewmodels.WeatherViewModel


class WeatherFragment : Fragment() {

    private lateinit var apiInterface : RestApi
    private lateinit var retrofit: Retrofit

    val viewModel = WeatherViewModel()
    val q : String = "Bishkek"
    val appid : String = "e174a606afeb32e8177dfa2ec35cc85d"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getWeather()
    }


    fun getWeather(){


        retrofit = ApiFactory.getRetrofit1()
        apiInterface = retrofit.create(RestApi::class.java)
        apiInterface.getWeather(q,appid).enqueue(object : Callback<WeatherResponse>{
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Toast.makeText(context, "Ошибка запроса", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                Log.d("body", response.body().toString())

                if (response.isSuccessful){
//                    var celsius: String = viewModel.getTemp(response.body()?.temp.toString())
                    Log.d("body", response.body().toString())

                }else {
                    Toast.makeText(context, "Ошибка запроса", Toast.LENGTH_SHORT).show()
                    Log.d("body", response.errorBody().toString())

                }
            }

        })

    }
    
}