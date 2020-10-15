package ru.mitapp.intelligentia.viewmodels

import androidx.lifecycle.ViewModel

class WeatherViewModel: ViewModel() {

    fun getTemp(degr:String): String{
        var cel = degr.toInt() - 273.15
        return cel.toString()
    }
}