package ru.mitapp.intelligentia.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import ru.mitapp.intelligentia.R
import ru.mitapp.intelligentia.Urlview
import ru.mitapp.intelligentia.adapters.NewsAdapter
import ru.mitapp.intelligentia.api.ApiFactory
import ru.mitapp.intelligentia.api.RestApi
import ru.mitapp.intelligentia.models.News
import ru.mitapp.intelligentia.models.NewsResponse


class NewsFragment : Fragment(), NewsAdapter.Listener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var apiInterface : RestApi
    private lateinit var retrofit: Retrofit




    val apiKey : String = "ba88909bbda0454aaa503a8fff5e1225"
    val country : String = "ru"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

       recyclerView = view.findViewById(R.id.newsRecycler)
        getNews()


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }




    fun getNews(){
        retrofit = ApiFactory.getRetrofit()
        apiInterface = retrofit.create(RestApi::class.java)

        apiInterface.getNews(apiKey, country).enqueue(object : Callback<NewsResponse> {
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Toast.makeText(context, "Ошибка запроса", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {

                if (response.isSuccessful){
                    if (response.body()?.articles != null){

                        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                        recyclerView.adapter = NewsAdapter(response.body()?.articles!!, this@NewsFragment)
                    }


                } else{
                    Toast.makeText(context, "Ошибка запроса", Toast.LENGTH_SHORT).show()
                }
            }

        })
    }

    override fun onItemClick(news: News) {
        val intent = Intent(context, Urlview::class.java)
        intent.putExtra("url", news.url)
        startActivity(intent)
    }
}