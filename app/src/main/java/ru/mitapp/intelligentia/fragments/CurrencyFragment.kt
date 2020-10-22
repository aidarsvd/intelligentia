package ru.mitapp.intelligentia.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_currency.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import ru.mitapp.intelligentia.R
import ru.mitapp.intelligentia.api.ApiFactory
import ru.mitapp.intelligentia.api.RestApi
import ru.mitapp.intelligentia.models.CurrencyResponse
import ru.mitapp.intelligentia.utils.PreferencesUtils
import ru.mitapp.intelligentia.viewmodels.ConvertViewModel


class CurrencyFragment : Fragment() {

    private lateinit var apiInterface: RestApi
    private lateinit var retrofit: Retrofit

    lateinit var symbol: String

    val access_key = "bKJMVQ6jaEjE0pPeDGijnWHgF6EpZ5rvEzed5UZD1B3ly7z1oD"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_currency, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pref = PreferencesUtils


        btn.setOnClickListener {


            var base: String = base.getSelectedItem().toString()
            var tocon: String = converted.getSelectedItem().toString()

            var inputText: String = input.text.toString()

            if (definition(base, tocon)){
                result.text = inputText
            }else{
                symbol = "$base/$tocon"
                getCurrency(base, inputText)
            }



        }

    }

    fun getCurrency(base: String, input: String){

        val convert = ConvertViewModel()
        retrofit = ApiFactory.getRetrofit2()
        apiInterface = retrofit.create(RestApi::class.java)

        apiInterface.getCurrency(symbol, access_key).enqueue(object : Callback<CurrencyResponse>{
            override fun onFailure(call: Call<CurrencyResponse>, t: Throwable) {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()

            }

            override fun onResponse(
                call: Call<CurrencyResponse>,
                response: Response<CurrencyResponse>
            ) {
                if (response.isSuccessful && response.body() != null){
                    var final_res = convert.getCurrency(input, response.body()!!.response[0].price)
                    result.text = final_res
                }
            }

        })


    }

    fun definition(a:String, b:String): Boolean {
        if(a == b){
            return true
        }
        return false
    }




}