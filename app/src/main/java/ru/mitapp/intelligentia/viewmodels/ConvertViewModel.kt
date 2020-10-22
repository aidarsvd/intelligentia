package ru.mitapp.intelligentia.viewmodels

import androidx.lifecycle.ViewModel

class ConvertViewModel: ViewModel() {

    fun getTemp(degr: String?): String{
        var cel = degr?.toLong()?.minus(273.15)
        return cel.toString()
    }

    fun getCurrency(base: String, con: String): String{
        var res = base.toFloat() * con.toFloat()
        return res.toString()
    }

}