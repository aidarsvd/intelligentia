package ru.mitapp.intelligentia.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
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


class CurrencyFragment : Fragment() {

    private lateinit var apiInterface: RestApi
    private lateinit var retrofit: Retrofit

    lateinit var q: String
    val compact: String = "ultra"
    val apiKey = "fe4202ff43aacf90dd31"


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

        btn.setOnClickListener {
            var base: String = base.getSelectedItem().toString()
            var tocon: String = converted.getSelectedItem().toString()
            q = "${base}_${tocon}"

            getCurrency()

        }

    }

    fun getCurrency(){

        retrofit = ApiFactory.getRetrofit2()
        apiInterface = retrofit.create(RestApi::class.java)

        apiInterface.getCurrency(q, compact, apiKey).enqueue(object : Callback<CurrencyResponse>{
            override fun onFailure(call: Call<CurrencyResponse>, t: Throwable) {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<CurrencyResponse>,
                response: Response<CurrencyResponse>
            ) {
                if (response.isSuccessful){
                    result.text = response.body()!!.currency

                }
            }

        })


    }




}