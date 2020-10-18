package ru.mitapp.intelligentia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ProgressBar
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import ru.mitapp.intelligentia.api.ApiFactory
import ru.mitapp.intelligentia.api.RestApi
import ru.mitapp.intelligentia.models.WeatherResponse
import ru.mitapp.intelligentia.utils.ConnectionCheck

class SplashActivity : AppCompatActivity() {
    private lateinit var processBar: ProgressBar

    val connCheck = ConnectionCheck()
    private lateinit var apiInterface : RestApi
    private lateinit var retrofit: Retrofit
    val q : String = "Bishkek"
    val appid : String = "e174a606afeb32e8177dfa2ec35cc85d"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        processBar = findViewById(R.id.progressBar)


        Handler().postDelayed({
            if (connCheck.isOnline(this)){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "No internet connection", Toast.LENGTH_LONG).show()
            }
        },2000)


    }

}