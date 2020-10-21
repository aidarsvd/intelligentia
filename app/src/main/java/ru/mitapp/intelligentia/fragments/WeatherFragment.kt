package ru.mitapp.intelligentia.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_weather.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import ru.mitapp.intelligentia.R
import ru.mitapp.intelligentia.adapters.NewsAdapter
import ru.mitapp.intelligentia.api.ApiFactory
import ru.mitapp.intelligentia.api.RestApi
import ru.mitapp.intelligentia.models.NewsResponse
import ru.mitapp.intelligentia.models.Weather
import ru.mitapp.intelligentia.models.WeatherResponse
import ru.mitapp.intelligentia.viewmodels.WeatherViewModel


class WeatherFragment : Fragment() {

    private lateinit var apiInterface : RestApi
    private lateinit var retrofit: Retrofit
    private lateinit var processBar: ProgressBar


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
        processBar = progressBar
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
                if (response.isSuccessful){

                    var celsium = response.body()!!.main!!.temp - 273.15

                    degrees.text = "${celsium.toInt()}°C"
                    city.text = response.body()!!.name



                    var celsium1 = response.body()!!.main!!.feels_like - 273.15


                    feels_like.text = "Feels like: ${celsium1.toInt()}°C"
                    pressure.text = "Pressure: ${response.body()!!.main!!.pressure}"
                    humidity.text = "Humidity ${response.body()!!.main!!.humidity}"

                    visibility.text = "Visibility: ${response.body()!!.visibility}"

                    windspeed.text = "Wind speed ${response.body()!!.wind!!.speed}"
                    winddegrees.text = "Wind degrees: ${response.body()!!.wind!!.deg}"

                    processBar.visibility = View.GONE


                }else {
                    Toast.makeText(context, "Ошибка запроса", Toast.LENGTH_SHORT).show()
                }
            }

        })

    }

}