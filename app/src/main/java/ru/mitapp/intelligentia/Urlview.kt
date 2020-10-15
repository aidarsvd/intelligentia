package ru.mitapp.intelligentia

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_urlview.*

class Urlview : AppCompatActivity() {
    val newsUrl:String?
        get() = intent.getStringExtra("url")


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_urlview)

        webViewSetup()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetJavaScriptEnabled")
    private fun webViewSetup(){
        wb_view.webViewClient = WebViewClient()

        wb_view.apply {
            loadUrl(newsUrl!!)
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true

        }
    }

}